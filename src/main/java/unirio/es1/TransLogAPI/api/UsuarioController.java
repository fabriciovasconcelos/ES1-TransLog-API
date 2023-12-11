package unirio.es1.TransLogAPI.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unirio.es1.TransLogAPI.domain.Usuario;
import unirio.es1.TransLogAPI.domain.dto.UsuarioInDTO;
import unirio.es1.TransLogAPI.domain.dto.UsuarioOutDTO;
import unirio.es1.TransLogAPI.service.UsuarioService;

import java.util.Optional;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService service;
    @Autowired
    private UsuarioConverter converter;

    @PostMapping
    public UsuarioOutDTO post(@RequestBody UsuarioInDTO inDTO){
        Usuario usuario = converter.inDTOtoEntity(inDTO);
        Usuario usarioSalvo = service.save(usuario);
        return converter.entityToOutDTO(usarioSalvo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioOutDTO> get(@PathVariable Long id){
        Optional<Usuario> usuario = service.findById(id);
        return usuario.isPresent() ? ResponseEntity.ok(converter.entityToOutDTO(usuario.get())) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<UsuarioOutDTO> getLogado(){
        Usuario usuario = service.findLogado();

        return ResponseEntity.ok(converter.entityToOutDTO(usuario));
    }
}
