package unirio.es1.TransLogAPI.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import unirio.es1.TransLogAPI.domain.Endereco;

import java.util.Optional;

@Transactional
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    Optional<Endereco> findById(Long id);
}
