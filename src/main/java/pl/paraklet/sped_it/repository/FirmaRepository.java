package pl.paraklet.sped_it.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.paraklet.sped_it.model.Firma;

import java.util.Optional;

@Repository
public interface FirmaRepository extends JpaRepository<Firma, Long> {
    Optional<Firma> findByEmail(String email);
}
