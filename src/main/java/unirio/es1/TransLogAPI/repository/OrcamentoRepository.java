package unirio.es1.TransLogAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unirio.es1.TransLogAPI.domain.Orcamento;

public interface OrcamentoRepository extends JpaRepository<Orcamento, Long> {
}
