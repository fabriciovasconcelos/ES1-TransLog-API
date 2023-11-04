package unirio.es1.TransLogAPI.domain.dto;

import org.springframework.stereotype.Component;

@Component
public class ServicoDTO {
    private Double peso;
    private String descricao;

    private Long enderecoBuscaId;

    private Long enderecoEntregaId;

    // Dimensoes
    private Integer largura;
    private Integer altura;
    private Integer comprimento;

    public ServicoDTO() {super();}

    public ServicoDTO(Double peso, String descricao, Long enderecoBuscaId, Long enderecoEntregaId, Integer largura, Integer altura, Integer comprimento) {
        this.peso = peso;
        this.descricao = descricao;
        this.enderecoBuscaId = enderecoBuscaId;
        this.enderecoEntregaId = enderecoEntregaId;
        this.largura = largura;
        this.altura = altura;
        this.comprimento = comprimento;
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
