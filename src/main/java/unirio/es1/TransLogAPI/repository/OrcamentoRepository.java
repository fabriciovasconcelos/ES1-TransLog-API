package unirio.es1.TransLogAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unirio.es1.TransLogAPI.domain.Orcamento;
import unirio.es1.TransLogAPI.domain.Servico;

import java.util.Optional;

public interface OrcamentoRepository extends JpaRepository<Orcamento, Long> {
    Optional<Orcamento> findByServico(Optional<Servico> servico);
}
