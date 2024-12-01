package pl.paraklet.sped_it.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.paraklet.sped_it.model.GieldaLadunkow;
import pl.paraklet.sped_it.repository.GieldaLadunkowRepository;

@AllArgsConstructor
@Service
public class GieldaLadunkowService {

    private GieldaLadunkowRepository gieldaLadunkowRepository;

    public String dodajLadunek() {
        return "Rekord dodany do Gieldy Ladunkow";
    }

}
