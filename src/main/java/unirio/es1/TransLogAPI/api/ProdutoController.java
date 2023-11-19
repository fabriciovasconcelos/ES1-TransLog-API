package unirio.es1.TransLogAPI.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unirio.es1.TransLogAPI.domain.Produto;
import unirio.es1.TransLogAPI.service.ProdutoService;

import java.util.Optional;

@RestController
@RequestMapping("api/produto")
public class ProdutoController {
    @Autowired
    private ProdutoService service;

    @PostMapping
    public Produto post(@RequestBody Produto produto){
        return service.save(produto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Produto>> getById(@PathVariable("id") Long id){
        Optional<Produto> produtoProcurado = service.getById(id);
        return !produtoProcurado.isEmpty() ? ResponseEntity.ok(produtoProcurado) : ResponseEntity.notFound().build();
    }
}
