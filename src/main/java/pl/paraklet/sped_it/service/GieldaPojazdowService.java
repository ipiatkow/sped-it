package pl.paraklet.sped_it.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import org.springframework.stereotype.Service;
import pl.paraklet.sped_it.model.GieldaPojazdow;
import pl.paraklet.sped_it.repository.GieldaPojazdowRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class GieldaPojazdowService {

    private GieldaPojazdowRepository gieldaPojazdowRepository;

    public String dodajDoGielbyPojazdow(GieldaPojazdow gieldaPojazdow) {
        gieldaPojazdowRepository.save(gieldaPojazdow);
        return "Dodałem nowy wpis do Giełby Pojazdów";
    }

    public List<GieldaPojazdow> pokazWszystkieWpisy() {
        return gieldaPojazdowRepository.findAll();
    }
}
