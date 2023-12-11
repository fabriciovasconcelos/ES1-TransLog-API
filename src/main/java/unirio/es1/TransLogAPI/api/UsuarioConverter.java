package unirio.es1.TransLogAPI.api;

import org.springframework.stereotype.Component;
import unirio.es1.TransLogAPI.domain.Usuario;
import unirio.es1.TransLogAPI.domain.dto.UsuarioInDTO;
import unirio.es1.TransLogAPI.domain.dto.UsuarioOutDTO;

import java.util.stream.Collectors;

@Component
public class UsuarioConverter {
    public UsuarioOutDTO entityToOutDTO(Usuario usuario){
        UsuarioOutDTO dto = new UsuarioOutDTO();

        dto.setId(usuario.getId());
        dto.setNome(usuario.getNome());
        dto.setEmail(usuario.getEmail());
        dto.setTelefone(usuario.getTelefone());
        dto.setCpf(usuario.getCpf());
        dto.setCargos(usuario.getCargos().stream().map(Enum::toString).collect(Collectors.toSet()));

        return dto;
    }

    public Usuario inDTOtoEntity(UsuarioInDTO dto){
        Usuario usuario = new Usuario();

        usuario.setNome(dto.getNome());
        usuario.setEmail((dto.getEmail()));
        usuario.setTelefone(dto.getTelefone());
        usuario.setCpf(dto.getCpf());
        usuario.setSenha(dto.getSenha());

        return usuario;
    }
}
