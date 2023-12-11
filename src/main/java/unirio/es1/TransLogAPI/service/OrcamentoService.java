package unirio.es1.TransLogAPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unirio.es1.TransLogAPI.domain.Orcamento;
import unirio.es1.TransLogAPI.domain.Servico;
import unirio.es1.TransLogAPI.repository.OrcamentoRepository;
import unirio.es1.TransLogAPI.security.AuthorizationException;

import java.util.List;
import java.util.Optional;

@Service
public class OrcamentoService {

    @Autowired
    private OrcamentoRepository repository;
    @Autowired
    private SecurityService securityService;

    @Autowired
    private ServicoService servicoService;

    public Orcamento save(Orcamento orcamento){
        if(securityService.isOrcamento()) {
            return repository.save(orcamento);
        }
        else{
            throw new AuthorizationException("Acesso negado.");
        }
    }

    public List<Orcamento> getOrcamentos(){
        if(securityService.isOrcamento()) {
            return repository.findAll();
        }
        else{
            throw new AuthorizationException("Acesso negado.");
        }
    }

    public Optional<Orcamento> findById(Long servicoId){

        Optional<Servico> servico = servicoService.findById(servicoId);


        Optional<Orcamento> orcamento = repository.findByServico(servico);

        if(securityService.isOrcamento() || orcamento.isEmpty() ||
                orcamento.get().getServico().getRemetente().getId().equals(securityService.idLogado())) {
            return orcamento;
        }
        else {
            throw new AuthorizationException("Acesso negado.");
        }
    }
}
