package unirio.es1.TransLogAPI.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import unirio.es1.TransLogAPI.domain.Servico;
import unirio.es1.TransLogAPI.domain.dto.ServicoDTO;
import unirio.es1.TransLogAPI.service.*;

@Component
public class ServicoConverter {
    @Autowired
    private EnderecoService enderecoService;

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private ServicoService servicoService;

    @Autowired
    private DestinatarioService destinatarioService;

    @Autowired
    private UsuarioService usuarioService;

    public ServicoDTO entityToDTO(Servico servico){
        ServicoDTO dto = new ServicoDTO();

        dto.setDescricao(servico.getDescricao());
        dto.setEnderecoBuscaId(servico.getEnderecoBusca().getId());
        dto.setEnderecoEntregaId(servico.getEnderecoEntrega().getId());
        dto.setProdutoId(servico.getProduto().getId());
        dto.setPagamento(servico.getPagamento());
        dto.setStatus(servico.getStatus());

        return dto;
    }

    public Servico dtoToEntity(ServicoDTO dto){
        Servico servico = new Servico();


        servico.setDescricao(dto.getDescricao());
        servico.setEnderecoBusca(enderecoService.getById(dto.getEnderecoBuscaId()).get());
        servico.setEnderecoEntrega(enderecoService.getById(dto.getEnderecoEntregaId()).get());
        servico.setProduto(produtoService.getById(dto.getProdutoId()).get());
        servico.setPagamento(dto.getPagamento());
        servico.setDestinatario(destinatarioService.findById(dto.getDestinatarioId()).get());
        servico.setRemetente(usuarioService.findById(dto.getRemetenteId()).get());
        servico.setStatus(dto.getStatus());
        return servico;
    }

}
