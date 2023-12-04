package unirio.es1.TransLogAPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unirio.es1.TransLogAPI.domain.Servico;
import unirio.es1.TransLogAPI.repository.ServicoRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository repository;

    public Servico atualizarStatus(Long id, String status){
        Optional<Servico> servicoASerAtualizado = findById(id);

        if(servicoASerAtualizado.isPresent()){
            Servico servico = servicoASerAtualizado.get();
            servico.setStatus(status);
            return repository.save(servico);
        }else {
            throw new NoSuchElementException("Serviço não encontrado com o ID: " + id);
        }

    }

    public Servico save(Servico servico){
        return repository.save(servico);
    }

    public Optional<Servico> findById(Long id){
        return repository.findById(id);
    }

    public List<Servico> getServicos(){
        return repository.findAll();
    }

    public List<Servico> getServicosByRemetente(Long managerId){
        return repository.findAllByRemetenteId(managerId);
    }
}
