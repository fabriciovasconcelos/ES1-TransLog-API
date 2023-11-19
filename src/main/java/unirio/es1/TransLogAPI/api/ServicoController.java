package unirio.es1.TransLogAPI.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unirio.es1.TransLogAPI.domain.Servico;
import unirio.es1.TransLogAPI.domain.dto.ServicoDTO;
import unirio.es1.TransLogAPI.service.ServicoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/servico")
public class ServicoController {


    @Autowired
    private ServicoService service;

    @Autowired
    private ServicoConverter converter;

    @PostMapping
    public Servico post(@RequestBody ServicoDTO dto){
        Servico servico = converter.dtoToEntity(dto);
        return service.save(servico);
    }

    @PutMapping("/{id}/avaliar-orcamento")
    public ResponseEntity<String> avaliarOrcamento(@PathVariable Long id, @RequestParam String status){
        try {
            service.atualizarStatus(id, status);
            return ResponseEntity.ok("Status atualizado com sucesso");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao atualizar status: " + e.getMessage());
        }
    }

    @GetMapping("/list")
    public ResponseEntity<List<Servico>> get(){
       return new ResponseEntity<>(service.getServicos(), HttpStatus.OK);
    }


}
