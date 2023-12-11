package unirio.es1.TransLogAPI.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import unirio.es1.TransLogAPI.domain.Endereco;
import unirio.es1.TransLogAPI.domain.dto.EnderecoDTO;
import unirio.es1.TransLogAPI.service.UsuarioService;

import java.util.NoSuchElementException;

@Component
public class EnderecoConverter {
    @Autowired
    private UsuarioService usuarioService;
    public EnderecoDTO entityToDTO(Endereco endereco){
        EnderecoDTO dto = new EnderecoDTO();

        dto.setId(endereco.getId());
        dto.setEstado(endereco.getEstado());
        dto.setMunicipio(endereco.getMunicipio());
        dto.setBairro(endereco.getBairro());
        dto.setRua(endereco.getRua());
        dto.setNumero(endereco.getNumero());
        dto.setComplemento(endereco.getComplemento());
        dto.setCep(endereco.getCep());
        if(endereco.getUsuario() != null) {
            dto.setUsuarioId(endereco.getUsuario().getId());
        }

        return dto;
    }

    public Endereco dtoToEntity(EnderecoDTO dto){
        Endereco endereco = new Endereco();

        endereco.setId(dto.getId());
        endereco.setEstado(dto.getEstado());
        endereco.setMunicipio(dto.getMunicipio());
        endereco.setBairro(dto.getBairro());
        endereco.setRua(dto.getRua());
        endereco.setNumero(dto.getNumero());
        endereco.setComplemento(dto.getComplemento());
        endereco.setCep(dto.getCep());
        if(dto.getUsuarioId() != null) {
            endereco.setUsuario(usuarioService.findById(dto.getUsuarioId()).orElseThrow(
                    () -> new NoSuchElementException("Não existe usuario com id: " + dto.getUsuarioId())));
        }

        return endereco;
    }
}
