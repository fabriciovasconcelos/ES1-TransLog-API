package unirio.es1.TransLogAPI.domain.dto;

import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class UsuarioOutDTO {
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String cpf;

    private Set<String> cargos;

    public UsuarioOutDTO() {
        super();
    }

    public UsuarioOutDTO(Long id, String nome, String email, String telefone, String cpf, Set<String> cargos) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.cpf = cpf;
        this.cargos = cargos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Set<String> getCargos() {
        return cargos;
    }

    public void setCargos(Set<String> cargos) {
        this.cargos = cargos;
    }
}
