package unirio.es1.TransLogAPI.service;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import unirio.es1.TransLogAPI.domain.CargoEnum;
import unirio.es1.TransLogAPI.security.AuthorizationException;
import unirio.es1.TransLogAPI.security.UserSpringSecurity;

@Service
public class SecurityService {

    public boolean logado(){
        UserSpringSecurity userSpringSecurity = authenticated();

        return logado(userSpringSecurity);
    }

    private boolean logado(UserSpringSecurity userSpringSecurity){
        return userSpringSecurity != null && userSpringSecurity.getId() != null;
    }

    public Long idLogado(){
        UserSpringSecurity userSpringSecurity = authenticated();

        if(logado(userSpringSecurity)) {
            return userSpringSecurity.getId();
        }

        throw new AuthorizationException("Acesso negado.");
    }

    public boolean isCliente(){
        return hasCargo(CargoEnum.CLIENTE);
    }

    public boolean isFuncionario(){
        return isOrcamento()  || isLogistica() || isTransporte();
    }

    public boolean isOrcamento(){
        return hasCargo(CargoEnum.ORCAMENTO);
    }

    public boolean isLogistica(){
        return hasCargo(CargoEnum.LOGISTICA);
    }

    public boolean isTransporte(){
        return hasCargo(CargoEnum.TRANSPORTE);
    }

    private boolean hasCargo(CargoEnum cargo){
        UserSpringSecurity userSpringSecurity = authenticated();
        return logado(userSpringSecurity) && userSpringSecurity.hasHole(cargo);
    }

    private UserSpringSecurity authenticated(){
        try {
            return (UserSpringSecurity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        } catch (Exception var3) {
            return null;
        }
    }
}
