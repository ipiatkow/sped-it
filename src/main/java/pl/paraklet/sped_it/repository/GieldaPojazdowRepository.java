package pl.paraklet.sped_it.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.paraklet.sped_it.model.GieldaPojazdow;

import java.util.List;

@Repository
public interface GieldaPojazdowRepository extends JpaRepository<GieldaPojazdow, Long> {
    List<GieldaPojazdow> findAll();
}