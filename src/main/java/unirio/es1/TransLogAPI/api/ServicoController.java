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
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/servico")
public class ServicoController {


    @Autowired
    private ServicoService service;

    @Autowired
    private ServicoConverter converter;

    @PostMapping
    public ServicoDTO post(@RequestBody ServicoDTO dto){
        Servico servico = converter.dtoToEntity(dto);
        Servico servicoSalvo = service.save(servico);

        return converter.entityToDTO(servicoSalvo);
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
    public ResponseEntity<List<ServicoDTO>> get(){
        List<Servico> servicos = service.getServicos();
        List<ServicoDTO> servicoDTOS = servicos.stream().map(servico -> converter.entityToDTO(servico)).collect(Collectors.toList());
        return new ResponseEntity<>(servicoDTOS, HttpStatus.OK);
    }


    @GetMapping("/manager/{managerId}")
    public ResponseEntity<List<ServicoDTO>> get(@PathVariable Long managerId){
        List<Servico> servicos = service.getServicosByRemetente(managerId);
        List<ServicoDTO> servicoDTOS = servicos.stream().map(servico -> converter.entityToDTO(servico)).collect(Collectors.toList());

        return ResponseEntity.ok().body(servicoDTOS);
    }

    @GetMapping("/{servicoId}")
    public ResponseEntity<ServicoDTO> getServicoById(@PathVariable Long servicoId){
        Optional<Servico> servico = service.findById(servicoId);


        return servico.isPresent() ? ResponseEntity.ok(converter.entityToDTO(servico.get())) : ResponseEntity.notFound().build();
    }
}
