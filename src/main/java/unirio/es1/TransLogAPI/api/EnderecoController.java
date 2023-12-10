package unirio.es1.TransLogAPI.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unirio.es1.TransLogAPI.domain.Endereco;
import unirio.es1.TransLogAPI.domain.Orcamento;
import unirio.es1.TransLogAPI.service.EnderecoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService service;


    @PostMapping
    public Endereco post(@RequestBody Endereco endereco){
        return service.save(endereco);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Endereco>> getById(@PathVariable("id") Long id){
     Optional<Endereco> enderecoProcurado = service.getById(id);
     return !enderecoProcurado.isEmpty() ? ResponseEntity.ok(enderecoProcurado) : ResponseEntity.notFound().build();
    }

    @GetMapping("/list")
    public ResponseEntity<List<Endereco>> listAllOrcamento(){

        List<Endereco> enderecos = service.getEnderecos();

        return !enderecos.isEmpty() ? ResponseEntity.ok(enderecos) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id){
        service.deleteEndereco(id);
    }
}
