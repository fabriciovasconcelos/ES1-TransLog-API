package unirio.es1.TransLogAPI.domain.dto;

import org.springframework.stereotype.Component;

@Component
public class ServicoDTO {
    private Long id;

    private String descricao;

    private Long enderecoBuscaId;

    private Long enderecoEntregaId;

    private Long produtoId;

    private String pagamento;

    private Long remetenteId;

    private Long destinatarioId;

    private String status;

    public ServicoDTO() {super();}

    public ServicoDTO(Long id, String descricao, Long enderecoBuscaId, Long enderecoEntregaId,
                      Long produtoId, String pagamento, Long remetenteId, Long destinatarioId,
                      String status) {
        this.id = id;
        this.descricao = descricao;
        this.enderecoBuscaId = enderecoBuscaId;
        this.enderecoEntregaId = enderecoEntregaId;
        this.produtoId = produtoId;
        this.pagamento = pagamento;
        this.remetenteId = remetenteId;
        this.destinatarioId = destinatarioId;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getPagamento() {
        return pagamento;
    }

    public void setPagamento(String pagamento) {
        this.pagamento = pagamento;
    }

    public Long getRemetenteId() {
        return remetenteId;
    }

    public void setRemetenteId(Long remetenteId) {
        this.remetenteId = remetenteId;
    }

    public Long getDestinatarioId() {
        return destinatarioId;
    }

    public void setDestinatarioId(Long destinatarioId) {
        this.destinatarioId = destinatarioId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
