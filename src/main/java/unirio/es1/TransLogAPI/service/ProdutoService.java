package unirio.es1.TransLogAPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unirio.es1.TransLogAPI.domain.Produto;
import unirio.es1.TransLogAPI.repository.ProdutoRepository;

import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public Produto save(Produto produto){
        return repository.save(produto);
    }
    public Optional<Produto> getById(Long id){
        return repository.findById(id);
    }
}
