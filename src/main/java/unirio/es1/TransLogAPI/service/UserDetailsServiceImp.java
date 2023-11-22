package unirio.es1.TransLogAPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import unirio.es1.TransLogAPI.domain.Usuario;
import unirio.es1.TransLogAPI.repository.UsuarioRepository;
import unirio.es1.TransLogAPI.security.UserSpringSecurity;

@Service
public class UserDetailsServiceImp implements UserDetailsService {
    private UsuarioRepository usuarioRepository;

    @Autowired
    public UserDetailsServiceImp(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario =  usuarioRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("Email não encontrado."));

        return new UserSpringSecurity(usuario.getId(), usuario.getEmail(), usuario.getSenha(), usuario.getCargos());
    }
}
