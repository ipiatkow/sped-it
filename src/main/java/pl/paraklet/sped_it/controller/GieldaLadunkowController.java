package pl.paraklet.sped_it.controller;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.paraklet.sped_it.model.Firma;
import pl.paraklet.sped_it.model.GieldaLadunkow;
import pl.paraklet.sped_it.model.GieldaLadunkowDTO;
import pl.paraklet.sped_it.model.enums.KodPanstwa;
import pl.paraklet.sped_it.model.Lokalizacja;
import pl.paraklet.sped_it.model.enums.RodzajFirmy;
import pl.paraklet.sped_it.model.enums.TypPojazdu;
import pl.paraklet.sped_it.repository.FirmaRepository;
import pl.paraklet.sped_it.repository.GieldaLadunkowRepository;
import pl.paraklet.sped_it.repository.LokalizacjaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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

        GieldaLadunkow gieldaLadunkow = new GieldaLadunkow(0l, miejsceZaladunku, miejsceRozladunku, TypPojazdu.CHŁODNIA, null, null, 24, 3, false, true, false, true, true, true, 1700, 30, LocalDate.now(), zleceniodawca);
        lokalizacjaRepository.save(miejsceRozladunku);
        lokalizacjaRepository.save(miejsceZaladunku);
        firmaRepository.save(zleceniodawca);
        gieldaLadunkowRepository.save(gieldaLadunkow);
    }

    @PostMapping("gieldaladunkow")
    public String dodajDoGieldyLadunkow(@RequestBody GieldaLadunkowDTO nowyLadunek) {
        Optional<Firma> zleceniodawca = firmaRepository.findByEmail(nowyLadunek.getFirmaEmail());
        if (zleceniodawca.isPresent()) {
            Lokalizacja miejsceZaladunku = nowyLadunek.getMiejsceZaladunku();
            Lokalizacja miejsceRozladunku = nowyLadunek.getMiejsceRozladunku();
            //Firma zleceniodawca = new Firma("Fiver", "irek.piatkowski@gmail.com", RodzajFirmy.ZLECENIODAWCA, "Ireneusz Piątkowski", "501022507");

            GieldaLadunkow gieldaLadunkow = new GieldaLadunkow(
                    nowyLadunek.getId(),
                    nowyLadunek.getMiejsceZaladunku(),
                    nowyLadunek.getMiejsceRozladunku(),
                    nowyLadunek.getTypPojazdu1(),
                    nowyLadunek.getTypPojazdu2(),
                    nowyLadunek.getTypPojazdu3(),
                    nowyLadunek.getLadownosc(),
                    nowyLadunek.getMultifracht(),
                    nowyLadunek.isFtl(),
                    nowyLadunek.isLtl(),
                    nowyLadunek.isZNaczepa(),
                    nowyLadunek.isSolo(),
                    nowyLadunek.isBus(),
                    nowyLadunek.isZPrzyczepa(),
                    nowyLadunek.getCenaPublikacji(),
                    nowyLadunek.getTerminPlatnosci(),
                    nowyLadunek.getDataPublikacji(),
                    zleceniodawca.get());
            lokalizacjaRepository.save(miejsceRozladunku);
            lokalizacjaRepository.save(miejsceZaladunku);
            firmaRepository.save(zleceniodawca.get());
            gieldaLadunkowRepository.save(gieldaLadunkow);
            return "Dodałem nowy ładunek do bazy danych";
        } else {
            return "Nie ma zleceniodawcy o adresie email: " + nowyLadunek.getFirmaEmail();
        }
    }
}
