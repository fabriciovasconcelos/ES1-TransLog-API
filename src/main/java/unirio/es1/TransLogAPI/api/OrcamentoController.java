package unirio.es1.TransLogAPI.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unirio.es1.TransLogAPI.domain.Orcamento;
import unirio.es1.TransLogAPI.domain.dto.OrcamentoDTO;
import unirio.es1.TransLogAPI.service.OrcamentoService;

import java.util.List;

@RestController
@RequestMapping("api/v0/orcamento")
public class OrcamentoController {

    @Autowired
    private OrcamentoService service;

    @Autowired
    private OrcamentoConverter converter;

    @PostMapping
    public Orcamento post(@RequestBody OrcamentoDTO dto){
        Orcamento orcamento = converter.dtoToEntity(dto);
        return service.save(orcamento);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Orcamento>> listAllOrcamento(){

        List<Orcamento> orcamentos = service.getOrcamentos();

        return !orcamentos.isEmpty() ? ResponseEntity.ok(orcamentos) : ResponseEntity.notFound().build();
    }

}
