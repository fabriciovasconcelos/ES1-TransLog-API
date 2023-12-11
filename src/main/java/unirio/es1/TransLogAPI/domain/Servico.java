package unirio.es1.TransLogAPI.domain;

import jakarta.persistence.*;

enum Status {
    APROVADO,
    REJEITADO,
    AGUARDANDO,
    REJEITADO_NA_COLETA,
    AGUARDANDO_ORCAMENTO
}

enum Pagamento {
    DEBITO,
    CREDITO,
    BOLETO,
    PIX
}

@Entity
@Table(name = "servico")
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;
    @ManyToOne
    @JoinColumn(name = "endereco_busca_id")
    private Endereco enderecoBusca;

    @ManyToOne
    @JoinColumn(name = "endereco_entrega_id")
    private Endereco enderecoEntrega;

    @OneToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    @Enumerated(EnumType.STRING)
    private Pagamento pagamento;

    @ManyToOne
    @JoinColumn(name = "remetente_id")
    private Usuario remetente;

    @ManyToOne
    @JoinColumn(name = "destinatario_id")
    private Destinatario destinatario;

    @Enumerated(EnumType.STRING)
    private Status status;

    public Servico(){}

    public Servico(String descricao, Status status) {
        this.descricao = descricao;
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

    public Endereco getEnderecoBusca() {
        return enderecoBusca;
    }

    public void setEnderecoBusca(Endereco enderecoBusca) {
        this.enderecoBusca = enderecoBusca;
    }

    public Endereco getEnderecoEntrega() {
        return enderecoEntrega;
    }

    public void setEnderecoEntrega(Endereco enderecoEntrega) {
        this.enderecoEntrega = enderecoEntrega;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Usuario getRemetente() {
        return remetente;
    }

    public void setRemetente(Usuario remetente) {
        this.remetente = remetente;
    }

    public Destinatario getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(Destinatario destinatario) {
        this.destinatario = destinatario;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getPagamento() {
        return pagamento.name();
    }

    public void setPagamento(String pagamento) {
        this.pagamento = Pagamento.valueOf(pagamento);
    }

    public String getStatus() {
        return status.name();
    }

    public void setStatus(String status) {
        this.status = Status.valueOf(status);
    }
}
