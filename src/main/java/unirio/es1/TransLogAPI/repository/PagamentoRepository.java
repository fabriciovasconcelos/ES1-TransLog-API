package unirio.es1.TransLogAPI.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import unirio.es1.TransLogAPI.domain.Pagamento;

import java.util.Optional;

@Transactional
public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
    Optional<Pagamento> findById(Long id);
}
