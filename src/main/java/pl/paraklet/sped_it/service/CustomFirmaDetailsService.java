package pl.paraklet.sped_it.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.paraklet.sped_it.repository.FirmaRepository;

@Service
public class CustomFirmaDetailsService implements UserDetailsService {

    private final FirmaRepository firmaRepository;

    public CustomFirmaDetailsService(FirmaRepository firmaRepository) {
        this.firmaRepository = firmaRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return firmaRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Firma not found with email: " + email));
    }
}
