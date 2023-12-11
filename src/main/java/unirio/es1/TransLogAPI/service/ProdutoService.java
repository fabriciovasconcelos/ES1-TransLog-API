package unirio.es1.TransLogAPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unirio.es1.TransLogAPI.domain.Produto;
import unirio.es1.TransLogAPI.repository.ProdutoRepository;
import unirio.es1.TransLogAPI.security.AuthorizationException;

import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;
    @Autowired
    private SecurityService securityService;

    public Produto save(Produto produto){
        if(produto.getId() == null || securityService.isFuncionario()){
            return repository.save(produto);
        }

        throw new AuthorizationException("Acesso negado.");
    }

    public Optional<Produto> getById(Long id){
        return repository.findById(id);
    }
}
