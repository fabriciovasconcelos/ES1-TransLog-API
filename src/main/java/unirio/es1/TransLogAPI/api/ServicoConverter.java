package unirio.es1.TransLogAPI.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import unirio.es1.TransLogAPI.domain.Servico;
import unirio.es1.TransLogAPI.domain.dto.ServicoDTO;
import unirio.es1.TransLogAPI.service.EnderecoService;
import unirio.es1.TransLogAPI.service.PagamentoService;
import unirio.es1.TransLogAPI.service.ProdutoService;
import unirio.es1.TransLogAPI.service.ServicoService;

@Component
public class ServicoConverter {
    @Autowired
    private EnderecoService enderecoService;

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private PagamentoService pagamentoService;

    @Autowired
    private ServicoService servicoService;

    public ServicoDTO entityToDTO(Servico servico){
        ServicoDTO dto = new ServicoDTO();

        dto.setDescricao(servico.getDescricao());
        dto.setEnderecoBuscaId(servico.getEnderecoBusca().getId());
        dto.setEnderecoEntregaId(servico.getEnderecoEntrega().getId());
        dto.setProdutoId(servico.getProduto().getId());
        dto.setPagamentoId(servico.getPagamento().getId());
        dto.setStatus(servico.getStatus());

        return dto;
    }

    public Servico dtoToEntity(ServicoDTO dto){
        Servico servico = new Servico();


        servico.setDescricao(dto.getDescricao());
        servico.setEnderecoBusca(enderecoService.getById(dto.getEnderecoBuscaId()).get());
        servico.setEnderecoEntrega(enderecoService.getById(dto.getEnderecoEntregaId()).get());
        servico.setProduto(produtoService.getById(dto.getProdutoId()).get());
        servico.setPagamento(pagamentoService.getById(dto.getPagamentoId()).get());
        servico.setStatus(dto.getStatus());
        return servico;

    }

}
