package unirio.es1.TransLogAPI.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "servico")
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double peso;
    private String descricao;
    @ManyToOne
    @JoinColumn(name = "endereco_busca_id")
    private Endereco enderecoBusca;

    @ManyToOne
    @JoinColumn(name = "endereco_entrega_id")
    private Endereco enderecoEntrega;


    // Dimensoes
    private Integer largura;
    private Integer altura;
    private Integer comprimento;

    public Servico(){}

    public Servico(Double peso, String descricao, Integer largura, Integer altura, Integer comprimento) {
        this.peso = peso;
        this.descricao = descricao;
        this.largura = largura;
        this.altura = altura;
        this.comprimento = comprimento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
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

    public Integer getLargura() {
        return largura;
    }

    public void setLargura(Integer largura) {
        this.largura = largura;
    }

    public Integer getAltura() {
        return altura;
    }

    public void setAltura(Integer altura) {
        this.altura = altura;
    }

    public Integer getComprimento() {
        return comprimento;
    }

    public void setComprimento(Integer comprimento) {
        this.comprimento = comprimento;
    }
}
