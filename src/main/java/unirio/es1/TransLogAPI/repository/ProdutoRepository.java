package unirio.es1.TransLogAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unirio.es1.TransLogAPI.domain.Produto;

import java.util.Optional;


public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    Optional<Produto> findById(Long id);
}
