package unirio.es1.TransLogAPI.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import unirio.es1.TransLogAPI.domain.Servico;
import unirio.es1.TransLogAPI.domain.dto.ServicoDTO;
import unirio.es1.TransLogAPI.service.EnderecoService;
import unirio.es1.TransLogAPI.service.ServicoService;

@Component
public class ServicoConverter {
    @Autowired
    private EnderecoService enderecoService;

//    @Autowired
//    private ServicoService servicoService;

    public ServicoDTO entityToDTO(Servico servico){
        ServicoDTO dto = new ServicoDTO();

        dto.setPeso(servico.getPeso());
        dto.setDescricao(servico.getDescricao());
        dto.setEnderecoBuscaId(servico.getEnderecoBusca().getId());
        dto.setEnderecoEntregaId(servico.getEnderecoEntrega().getId());
        dto.setLargura(servico.getLargura());
        dto.setAltura(servico.getAltura());
        dto.setComprimento(servico.getComprimento());

        return dto;
    }

    public Servico dtoToEntity(ServicoDTO dto){
        Servico servico = new Servico();

        servico.setPeso(dto.getPeso());
        servico.setDescricao(dto.getDescricao());
        servico.setEnderecoBusca(enderecoService.getById(dto.getEnderecoBuscaId()).get());
        servico.setEnderecoEntrega(enderecoService.getById(dto.getEnderecoEntregaId()).get());
        servico.setLargura(dto.getLargura());
        servico.setAltura(dto.getAltura());
        servico.setComprimento(dto.getComprimento());

        return servico;

    }

}
