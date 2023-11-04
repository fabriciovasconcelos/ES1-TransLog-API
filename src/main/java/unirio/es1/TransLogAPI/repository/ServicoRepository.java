package unirio.es1.TransLogAPI.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import unirio.es1.TransLogAPI.domain.Servico;

import java.util.Optional;

@Transactional
public interface ServicoRepository extends JpaRepository<Servico, Long> {
    Optional<Servico> findById(Long id);
}
