package unirio.es1.TransLogAPI.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unirio.es1.TransLogAPI.domain.Endereco;
import unirio.es1.TransLogAPI.repository.EnderecoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository repository;

    public Endereco save(Endereco endereco){
        return repository.save(endereco);
    }

    public Optional<Endereco> getById(Long id){
        return repository.findById(id);
    }

    public List<Endereco> getEnderecos(){
        return repository.findAll();
    }

    public void deleteEndereco(Long id){
        repository.deleteById(id);
    }
}
