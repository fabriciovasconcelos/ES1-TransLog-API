package unirio.es1.TransLogAPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unirio.es1.TransLogAPI.domain.Servico;
import unirio.es1.TransLogAPI.repository.ServicoRepository;
import unirio.es1.TransLogAPI.security.AuthorizationException;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository repository;
    @Autowired
    private SecurityService securityService;

    public Servico atualizarStatus(Long id, String status){
        if(securityService.isOrcamento()) {
            Optional<Servico> servicoASerAtualizado = findById(id);

            if (servicoASerAtualizado.isPresent()) {
                Servico servico = servicoASerAtualizado.get();
                servico.setStatus(status);
                return repository.save(servico);
            } else {
                throw new NoSuchElementException("Serviço não encontrado com o ID: " + id);
            }
        }
        else{
            throw new AuthorizationException("Acesso negado.");
        }
    }

    public Servico save(Servico servico){
        if(securityService.idLogado().equals(servico.getRemetente().getId())) {
            return repository.save(servico);
        }
        else{
            throw new AuthorizationException("Acesso negado.");
        }
    }

    public Optional<Servico> findById(Long id){
        Optional<Servico> servico =  repository.findById(id);

        if(securityService.isFuncionario() || servico.isEmpty() ||
            servico.get().getRemetente().getId().equals(securityService.idLogado())){
            return servico;
        }

        throw new AuthorizationException("Acesso negado.");
    }

    public List<Servico> getServicos(){
        if(securityService.isFuncionario()) {
            return repository.findAll();
        }
        else{
            throw new AuthorizationException("Acesso negado.");
        }
    }

    public List<Servico> getServicosByRemetente(Long remetenteId){
        if(securityService.isFuncionario() || securityService.idLogado().equals(remetenteId)){
            return repository.findAllByRemetenteId(remetenteId);
        }
        else{
            throw new AuthorizationException("Acesso negado.");
        }
    }
}
