package unirio.es1.TransLogAPI.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unirio.es1.TransLogAPI.domain.Endereco;
import unirio.es1.TransLogAPI.domain.dto.EnderecoDTO;
import unirio.es1.TransLogAPI.service.EnderecoService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService service;


    @Autowired
    private EnderecoConverter enderecoConverter;

    @PostMapping
    public EnderecoDTO post(@RequestBody EnderecoDTO dto){
        Endereco endereco = enderecoConverter.dtoToEntity(dto);
        Endereco enderecoSalvo = service.save(endereco);

        return enderecoConverter.entityToDTO(enderecoSalvo);
    }

    @PostMapping("/destinatario")
    public EnderecoDTO postDestinatario(@RequestBody EnderecoDTO dto){
        Endereco endereco = enderecoConverter.dtoToEntity(dto);
        Endereco enderecoSalvo = service.saveDestinatario(endereco);

        return enderecoConverter.entityToDTO(enderecoSalvo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnderecoDTO> getById(@PathVariable("id") Long id){
     Optional<Endereco> enderecoProcurado = service.getById(id);
     return !enderecoProcurado.isEmpty() ? ResponseEntity.ok(enderecoConverter.entityToDTO(enderecoProcurado.get())) : ResponseEntity.notFound().build();
    }

    @GetMapping("/list")
    public ResponseEntity<List<EnderecoDTO>> listAllEnderecos(){

        List<Endereco> enderecos = service.getEnderecos();
        List<EnderecoDTO> dtos = enderecos.stream().map(endereco -> enderecoConverter.entityToDTO(endereco)).collect(Collectors.toList());

        return !enderecos.isEmpty() ? ResponseEntity.ok(dtos) : ResponseEntity.notFound().build();
    }

    @GetMapping("/usuario")
    public ResponseEntity<List<EnderecoDTO>> listAllEnderecosUsuarioLogado(){
        List<Endereco> enderecos = service.getEnderecosUsuario();
        List<EnderecoDTO> dtos = enderecos.stream().map(endereco -> enderecoConverter.entityToDTO(endereco)).collect(Collectors.toList());

        return !enderecos.isEmpty() ? ResponseEntity.ok(dtos) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id){
        service.deleteEndereco(id);
    }
}
