package unirio.es1.TransLogAPI.domain.dto;

import org.springframework.stereotype.Component;

@Component
public class ServicoDTO {
    private String descricao;

    private Long enderecoBuscaId;

    private Long enderecoEntregaId;

    private Long produtoId;

    public ServicoDTO() {super();}

    public ServicoDTO(String descricao, Long enderecoBuscaId, Long enderecoEntregaId, Long produtoId) {
        this.descricao = descricao;
        this.enderecoBuscaId = enderecoBuscaId;
        this.enderecoEntregaId = enderecoEntregaId;
        this.produtoId = produtoId;
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

    public Long getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Long produtoId) {
        this.produtoId = produtoId;
    }
}
