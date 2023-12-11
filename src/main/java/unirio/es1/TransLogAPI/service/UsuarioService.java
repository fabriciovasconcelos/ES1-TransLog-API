package unirio.es1.TransLogAPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import unirio.es1.TransLogAPI.domain.CargoEnum;
import unirio.es1.TransLogAPI.domain.Usuario;
import unirio.es1.TransLogAPI.security.AuthorizationException;
import unirio.es1.TransLogAPI.repository.UsuarioRepository;
import unirio.es1.TransLogAPI.security.UserSpringSecurity;

import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private UsuarioRepository usuarioRepository;


    public Optional<Usuario> findById(Long id){
        return usuarioRepository.findById(id);
    }

    public Optional<Usuario> findByEmail(String email){
        return usuarioRepository.findByEmail(email);
    }

    public Usuario findLogado(){
        UserSpringSecurity userSpringSecurity = authenticated();

        return findById(userSpringSecurity.getId()).orElseThrow(()-> new AuthorizationException("Acesso negado."));
    }

    public Usuario save(Usuario usuario){
        usuario.setSenha(this.bCryptPasswordEncoder.encode(usuario.getSenha()));
        usuario.addProfile(CargoEnum.CLIENTE);
        return usuarioRepository.save(usuario);
    }

    public static UserSpringSecurity authenticated() {
        try {
            return (UserSpringSecurity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        } catch (Exception var3) {
            return null;
        }
    }
}
