package unirio.es1.TransLogAPI.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unirio.es1.TransLogAPI.domain.Servico;
import unirio.es1.TransLogAPI.domain.dto.ServicoDTO;
import unirio.es1.TransLogAPI.service.ServicoService;

import java.util.List;

@RestController
@RequestMapping("api/v0/servico")
public class ServicoController {


    @Autowired
    private ServicoService service;

    @Autowired
    private ServicoConverter converter;

    @PostMapping
    public Servico post(@RequestBody ServicoDTO dto){

        Servico servico = converter.dtoToEntity(dto);
        return service.save(servico);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Servico>> get(){
       return new ResponseEntity<>(service.getServicos(), HttpStatus.OK);
    }


}
