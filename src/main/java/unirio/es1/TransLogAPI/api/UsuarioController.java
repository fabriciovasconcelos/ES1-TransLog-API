package unirio.es1.TransLogAPI.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unirio.es1.TransLogAPI.domain.Usuario;
import unirio.es1.TransLogAPI.service.UsuarioService;

import java.util.Optional;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService service;

    @PostMapping
    public Usuario post(@RequestBody Usuario usuario){
        return service.save(usuario);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> get(@PathVariable Long id){
        Optional<Usuario> usuario = service.findById(id);
        return usuario.isPresent() ? ResponseEntity.ok(usuario.get()) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<Usuario> getLogado(){
        Usuario usuario = service.findLogado();

        return ResponseEntity.ok(usuario);
    }
}
