package unirio.es1.TransLogAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unirio.es1.TransLogAPI.domain.Destinatario;

public interface DestinatarioRepository extends JpaRepository<Destinatario, Long> {
}
