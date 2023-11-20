package unirio.es1.TransLogAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unirio.es1.TransLogAPI.domain.Usuario;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);
}
