package unirio.es1.TransLogAPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import unirio.es1.TransLogAPI.domain.CargoEnum;
import unirio.es1.TransLogAPI.domain.Usuario;
import unirio.es1.TransLogAPI.security.AuthorizationException;
import unirio.es1.TransLogAPI.repository.UsuarioRepository;

import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private SecurityService securityService;


    public Optional<Usuario> findById(Long id){
        if(securityService.isFuncionario() || securityService.idLogado().equals(id)){
            return usuarioRepository.findById(id);
        }

        throw new AuthorizationException("Acesso negado.");
    }

    public Usuario findLogado(){
        Long id = securityService.idLogado();
        if(id != null){
            return usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario não encontrado."));
        }
        else{
            throw new AuthorizationException("Acesso negado.");
        }
    }

    public Usuario save(Usuario usuario){
        usuario.setSenha(this.bCryptPasswordEncoder.encode(usuario.getSenha()));
        usuario.addProfile(CargoEnum.CLIENTE);
        return usuarioRepository.save(usuario);
    }
}
