package pl.paraklet.sped_it.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;



//@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Firma implements UserDetails {

    @Id
    @GeneratedValue
    private Long id;
    private String nazwa;
    private String email;
    private String nip;
    private RodzajFirmy rodzajFirmy;
    private String osobaKontaktowa;
    private String telefon;
    private String password;

    public Firma(String nazwa, String email, RodzajFirmy rodzajFirmy, String osobaKontaktowa, String telefon) {
        this.nazwa = nazwa;
        this.email = email;
        this.rodzajFirmy = rodzajFirmy;
        this.osobaKontaktowa = osobaKontaktowa;
        this.telefon = telefon;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList(); // Możesz dodać role/permissions jeśli są potrzebne
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email; // Spring Security wymaga identyfikatora użytkownika
    }



    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true; // Możesz dodać pole `enabled` i sprawdzać jego wartość
    }
}
