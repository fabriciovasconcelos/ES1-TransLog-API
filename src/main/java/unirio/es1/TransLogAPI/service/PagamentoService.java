package unirio.es1.TransLogAPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unirio.es1.TransLogAPI.domain.Pagamento;
import unirio.es1.TransLogAPI.repository.PagamentoRepository;

import java.util.Optional;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository repository;

    public Optional<Pagamento> getById(Long id){
        return repository.findById(id);
    }

}
