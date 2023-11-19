package unirio.es1.TransLogAPI.domain.dto;

import org.springframework.stereotype.Component;

@Component
public class ServicoDTO {
    private String descricao;

    private Long enderecoBuscaId;

    private Long enderecoEntregaId;

    private Long produtoId;

    private Long pagamentoId;

    private String status;

    public ServicoDTO() {super();}

    public ServicoDTO(String descricao, Long enderecoBuscaId, Long enderecoEntregaId, Long produtoId, Long pagamentoId, String status) {
        this.descricao = descricao;
        this.enderecoBuscaId = enderecoBuscaId;
        this.enderecoEntregaId = enderecoEntregaId;
        this.produtoId = produtoId;
        this.pagamentoId = pagamentoId;
        this.status = status;
    }


    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getEnderecoBuscaId() {
        return enderecoBuscaId;
    }

    public void setEnderecoBuscaId(Long enderecoBuscaId) {
        this.enderecoBuscaId = enderecoBuscaId;
    }

    public Long getEnderecoEntregaId() {
        return enderecoEntregaId;
    }

    public void setEnderecoEntregaId(Long enderecoEntregaId) {
        this.enderecoEntregaId = enderecoEntregaId;
    }

    public Long getProdutoId() {return produtoId;}

    public void setProdutoId(Long produtoId) {this.produtoId = produtoId;}

    public Long getPagamentoId() {
        return pagamentoId;
    }

    public void setPagamentoId(Long pagamentoId) {
        this.pagamentoId = pagamentoId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
