package unirio.es1.TransLogAPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unirio.es1.TransLogAPI.domain.Orcamento;
import unirio.es1.TransLogAPI.repository.OrcamentoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OrcamentoService {

    @Autowired
    private OrcamentoRepository repository;

    public Orcamento save(Orcamento orcamento){
        return repository.save(orcamento);
    }

    public List<Orcamento> getOrcamentos(){
        return repository.findAll();
    }

    public Optional<Orcamento> findById(Long orcamentoId){
        return repository.findById(orcamentoId);
    }
}
