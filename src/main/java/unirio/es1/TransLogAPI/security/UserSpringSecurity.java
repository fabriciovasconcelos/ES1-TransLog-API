package unirio.es1.TransLogAPI.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import unirio.es1.TransLogAPI.domain.CargoEnum;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.Set;

public class UserSpringSecurity implements UserDetails {
    private Long id;
    private String username;
    private String password;
    private Collection<? extends GrantedAuthority> autoridades;

    public UserSpringSecurity(Long id, String username, String password, Set<CargoEnum> cargos) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.autoridades = cargos.stream().map((c) -> {
            return new SimpleGrantedAuthority(c.getDesc());
        }).collect(Collectors.toList());
    }

    public boolean hasHole(CargoEnum c) {
        return this.getAuthorities().contains(new SimpleGrantedAuthority(c.getDesc()));
    }

    public UserSpringSecurity() {
    }

    public Long getId() {
        return this.id;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.autoridades;
    }

    public String getPassword() {
        return this.password;
    }

    public String getUsername() {
        return this.username;
    }

    public boolean isAccountNonExpired() {
        return true;
    }

    public boolean isAccountNonLocked() {
        return true;
    }

    public boolean isCredentialsNonExpired() {
        return true;
    }

    public boolean isEnabled() {
        return true;
    }

    public Collection<? extends GrantedAuthority> getAutoridades() {
        return this.autoridades;
    }
}
