package pl.paraklet.sped_it.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.paraklet.sped_it.model.GieldaLadunkow;

@Repository
public interface GieldaLadunkowRepository extends JpaRepository<GieldaLadunkow, Long> {
}
