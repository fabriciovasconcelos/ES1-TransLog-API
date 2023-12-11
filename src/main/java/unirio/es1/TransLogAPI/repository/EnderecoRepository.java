package unirio.es1.TransLogAPI.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import unirio.es1.TransLogAPI.domain.Endereco;

import java.util.List;
import java.util.Optional;

@Transactional
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    Optional<Endereco> findById(Long id);

    @Override
    void deleteById(Long id);

    @Query
    List<Endereco> findByUsuarioId(Long usarioId);
}
