package unirio.es1.TransLogAPI.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import unirio.es1.TransLogAPI.domain.Orcamento;
import unirio.es1.TransLogAPI.domain.dto.OrcamentoDTO;
import unirio.es1.TransLogAPI.service.OrcamentoService;
import unirio.es1.TransLogAPI.service.ServicoService;

@Component
public class OrcamentoConverter {

    @Autowired
    private ServicoService servicoService;

    @Autowired
    private OrcamentoService orcamentoService;

    public OrcamentoDTO entityToDTO(Orcamento orcamento){
        OrcamentoDTO dto = new OrcamentoDTO();
        dto.setCustoEmbalagem(orcamento.getCustoEmbalagem());
        dto.setTaxaDesistencia(orcamento.getTaxaDesistencia());
        dto.setValor(orcamento.getValor());
        dto.setPrazo(orcamento.getPrazo());
        dto.setServicoId(orcamento.getServico().getId());

        return dto;
    }

    public Orcamento dtoToEntity(OrcamentoDTO dto){
        Orcamento orcamento = new Orcamento();
        orcamento.setCustoEmbalagem(dto.getCustoEmbalagem());
        orcamento.setTaxaDesistencia(dto.getTaxaDesistencia());
        orcamento.setValor(dto.getValor());
        orcamento.setPrazo(dto.getPrazo());
        orcamento.setServico(servicoService.findById(dto.getServicoId()).get());


        return orcamento;
    }
}
