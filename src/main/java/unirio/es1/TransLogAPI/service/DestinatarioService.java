package unirio.es1.TransLogAPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unirio.es1.TransLogAPI.domain.Destinatario;
import unirio.es1.TransLogAPI.repository.DestinatarioRepository;

import java.util.Optional;

@Service
public class DestinatarioService {
    @Autowired
    private DestinatarioRepository destinatarioRepository;

    public Optional<Destinatario> findById(Long id){
        return destinatarioRepository.findById(id);
    }

    public Destinatario save(Destinatario destinatario){
        return destinatarioRepository.save(destinatario);
    }
}
