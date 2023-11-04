package unirio.es1.TransLogAPI.domain.dto;

import org.springframework.stereotype.Component;

@Component
public class OrcamentoDTO {
    private Double custoEmbalagem;
    private Double taxaDesistencia;
    private Double valor;
    private Integer prazo;
    private Long servicoId;

    public OrcamentoDTO(){};

    public OrcamentoDTO(Double custoEmbalagem, Double taxaDesistencia, Double valor, Integer prazo, Long servicoId) {
        this.custoEmbalagem = custoEmbalagem;
        this.taxaDesistencia = taxaDesistencia;
        this.valor = valor;
        this.prazo = prazo;
        this.servicoId = servicoId;
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

    public Long getServicoId() {
        return servicoId;
    }

    public void setServicoId(Long servicoId) {
        this.servicoId = servicoId;
    }
}
