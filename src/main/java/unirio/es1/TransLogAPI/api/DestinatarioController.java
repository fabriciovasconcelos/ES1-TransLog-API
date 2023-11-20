package unirio.es1.TransLogAPI.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unirio.es1.TransLogAPI.domain.Destinatario;
import unirio.es1.TransLogAPI.service.DestinatarioService;

import java.util.Optional;

@RestController
@RequestMapping("/api/destinatario")
public class DestinatarioController {
    @Autowired
    private DestinatarioService destinatarioService;

    @PostMapping
    public Destinatario post(@RequestBody Destinatario destinatario) {
        return destinatarioService.save(destinatario);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Destinatario> get(@PathVariable Long id){
        Optional<Destinatario> destinatario = destinatarioService.findById(id);

        return destinatario.isPresent() ? ResponseEntity.ok(destinatario.get()) : ResponseEntity.notFound().build();
    }
}
