package unirio.es1.TransLogAPI.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer largura;
    private Integer altura;
    private Integer comprimento;
    private Double peso;

    public Produto(){};

    public Produto(Integer largura, Integer altura, Integer comprimento, Double peso) {
        this.largura = largura;
        this.altura = altura;
        this.comprimento = comprimento;
        this.peso = peso;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }
}
