package pl.paraklet.sped_it.controller;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.paraklet.sped_it.model.Firma;
import pl.paraklet.sped_it.model.GieldaLadunkow;
import pl.paraklet.sped_it.model.enums.KodPanstwa;
import pl.paraklet.sped_it.model.Lokalizacja;
import pl.paraklet.sped_it.model.RodzajFirmy;
import pl.paraklet.sped_it.repository.FirmaRepository;
import pl.paraklet.sped_it.repository.GieldaLadunkowRepository;
import pl.paraklet.sped_it.repository.LokalizacjaRepository;

import java.util.List;

@NoArgsConstructor
@RestController
public class GieldaLadunkowController {

    @Autowired
    private FirmaRepository firmaRepository;
    @Autowired
    private LokalizacjaRepository lokalizacjaRepository;
    @Autowired
    private GieldaLadunkowRepository gieldaLadunkowRepository;

    @GetMapping("gieldaladunkow")
    public List<GieldaLadunkow> pokazWszystkieLadunki() {
        return gieldaLadunkowRepository.findAll();
    }

    @GetMapping("gieldaladunkowinit")
    public void dodajPrzykladowyWpis() {
        Lokalizacja miejsceZaladunku = new Lokalizacja(KodPanstwa.DE, "1234567", "Berlin");
        Lokalizacja miejsceRozladunku = new Lokalizacja(KodPanstwa.PL, "2345678", "Warszawa");
        Firma zleceniodawca = new Firma("Fiver", "irek.piatkowski@gmail.com", RodzajFirmy.ZLECENIODAWCA, "Ireneusz Piątkowski", "501022507");

        GieldaLadunkow gieldaLadunkow = new GieldaLadunkow(miejsceZaladunku, miejsceRozladunku, 3, false, true, false, true, true, true, 1700, 30, zleceniodawca);
        lokalizacjaRepository.save(miejsceRozladunku);
        lokalizacjaRepository.save(miejsceZaladunku);
        firmaRepository.save(zleceniodawca);
        gieldaLadunkowRepository.save(gieldaLadunkow);
    }




}
