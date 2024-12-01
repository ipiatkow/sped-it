package pl.paraklet.sped_it.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.paraklet.sped_it.model.Firma;
import pl.paraklet.sped_it.repository.FirmaRepository;

//@AllArgsConstructor
//@Getter
//@Setter
@Service
public class FirmaService {

    private final FirmaRepository firmaRepository;
    private final PasswordEncoder passwordEncoder;

    public FirmaService(FirmaRepository firmaRepository, PasswordEncoder passwordEncoder) {
        this.firmaRepository = firmaRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Firma registerFirma(Firma firma) {
        firma.setPassword(passwordEncoder.encode(firma.getPassword()));
        return firmaRepository.save(firma);
    }
}
