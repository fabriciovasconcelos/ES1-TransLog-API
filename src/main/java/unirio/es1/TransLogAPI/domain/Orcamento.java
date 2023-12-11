package unirio.es1.TransLogAPI.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "orcamento")
public class Orcamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "custo_embalagem")
    private Double custoEmbalagem;

    @JoinColumn(name = "taxa_desistencia")
    private Double taxaDesistencia;
    private Double valor;
    private Integer prazo;

    @OneToOne
    @JoinColumn(name = "servico_id")
    private Servico servico;

    public Orcamento(){}

    public Orcamento(Double custoEmbalagem, Double taxaDesistencia, Double valor, Integer prazo) {
        this.custoEmbalagem = custoEmbalagem;
        this.taxaDesistencia = taxaDesistencia;
        this.valor = valor;
        this.prazo = prazo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getCustoEmbalagem() {
        return custoEmbalagem;
    }

    public void setCustoEmbalagem(Double custoEmbalagem) {
        this.custoEmbalagem = custoEmbalagem;
    }

    public Double getTaxaDesistencia() {
        return taxaDesistencia;
    }

    public void setTaxaDesistencia(Double taxaDesistencia) {
        this.taxaDesistencia = taxaDesistencia;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Integer getPrazo() {
        return prazo;
    }

    public void setPrazo(Integer prazo) {
        this.prazo = prazo;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }
}
