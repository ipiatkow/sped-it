package pl.paraklet.sped_it.controller;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.paraklet.sped_it.model.*;
import pl.paraklet.sped_it.model.enums.KodPanstwa;
import pl.paraklet.sped_it.model.enums.RodzajFirmy;
import pl.paraklet.sped_it.model.enums.TypPojazdu;
import pl.paraklet.sped_it.model.enums.Waluta;
import pl.paraklet.sped_it.repository.LokalizacjaRepository;
import pl.paraklet.sped_it.repository.FirmaRepository;
import pl.paraklet.sped_it.service.GieldaPojazdowService;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@NoArgsConstructor
@RestController
public class GieldaPojazdowController {

    @Autowired
    private GieldaPojazdowService gieldaPojazdowService;
    @Autowired
    private FirmaRepository przewoznikRepository;
    @Autowired
    private LokalizacjaRepository lokalizacjaRepository;

    @Autowired

    public GieldaPojazdowController(GieldaPojazdowService gieldaPojazdowService, FirmaRepository przewoznikRepository, LokalizacjaRepository lokalizacjaRepository) {
        this.gieldaPojazdowService = gieldaPojazdowService;
        this.przewoznikRepository = przewoznikRepository;
        this.lokalizacjaRepository = lokalizacjaRepository;
    }

    @GetMapping("inicjalizacja")
    void inicjalizujGieldePojazdow() {

        Lokalizacja lokalizacjaDest1 = new Lokalizacja(KodPanstwa.DE, "1234567", "Berlin");
        Lokalizacja lokalizacjaDest2 = new Lokalizacja(KodPanstwa.DE, "2345678", "Hamburg");
        Lokalizacja miejsceZaladunku = new Lokalizacja(KodPanstwa.PL, "85-516", "Bydgoszcz");

        Set<Lokalizacja> miejsceRozladunku = new HashSet<>();
        miejsceRozladunku.add(lokalizacjaDest1);
        miejsceRozladunku.add(lokalizacjaDest2);
        LocalDate dostepnoscOd = LocalDate.of(2024, 11, 3);
        LocalDate dostepnoscDo = LocalDate.of(2024, 11, 8);
        LocalDate dataZgloszenia = LocalDate.now();
        Firma przewoznik = new Firma("Fiver Sp. z o.o.", "irekp@onet.pl", RodzajFirmy.PRZEWOZNIK, "Ireneusz Piątkowski", "501022507");


        przewoznikRepository.save(przewoznik);
        lokalizacjaRepository.save(miejsceZaladunku);
        lokalizacjaRepository.save(lokalizacjaDest1);
        lokalizacjaRepository.save(lokalizacjaDest2);

        GieldaPojazdow gieldaPojazdow = GieldaPojazdow.builder()
                .miejsceZaladunku(miejsceZaladunku)
                .miejsceRozladunku(miejsceRozladunku)
                .dostepnoscOd(dostepnoscOd)
                .dostepnoscDo(dostepnoscDo)
                .dataZgloszenia(dataZgloszenia)
                .przewoznik(przewoznik)
                .typPojazdu(TypPojazdu.CHŁODNIA)
                .ladownosc(22)
                .metrLadunkowy(50)
                .wyposazenie("bus, winda")
                .stawka(1.6f)
                .waluta(Waluta.EUR)
                .build();

        gieldaPojazdowService.dodajDoGielbyPojazdow(gieldaPojazdow);

    }

    @GetMapping("gieldapojazdow")
    public List<GieldaPojazdow> pokazWszystkieWpisyGieldaPojazdow() {
        return gieldaPojazdowService.pokazWszystkieWpisy();
    }

    @PostMapping("gieldapojazdow")
    public String dodajDoGieldaPojazdow(@RequestBody GieldaPojazdowDTO gieldaPojazdowDTO) {

        Set<Lokalizacja> miejsceRozladunku = new HashSet<>();
        for (Lokalizacja miejsceRozladunku1 : gieldaPojazdowDTO.getMiejsceRozladunku()) {
            lokalizacjaRepository.save(miejsceRozladunku1);
            miejsceRozladunku.add(miejsceRozladunku1);
        }
        Lokalizacja miejsceZaladunku = gieldaPojazdowDTO.getMiejsceZaladunku();
        lokalizacjaRepository.save(miejsceZaladunku);
        Firma przewoznik;
        Optional<Firma> przewoznikDto = przewoznikRepository.findByEmail(gieldaPojazdowDTO.getPrzewoznikEmail());

        if (przewoznikDto.isPresent()) {
            przewoznik = przewoznikDto.get();
            GieldaPojazdow gieldaPojazdow = GieldaPojazdow.builder()
                    .miejsceZaladunku(miejsceZaladunku)
                    .miejsceRozladunku(miejsceRozladunku)
                    .dostepnoscOd(gieldaPojazdowDTO.getDostepnoscOd())
                    .dostepnoscDo(gieldaPojazdowDTO.getDostepnoscDo())
                    .dataZgloszenia(gieldaPojazdowDTO.getDataZgloszenia())
                    .przewoznik(przewoznik)
                    .typPojazdu(gieldaPojazdowDTO.getTypPojazdu())
                    .ladownosc(gieldaPojazdowDTO.getLadownosc())
                    .metrLadunkowy(gieldaPojazdowDTO.getMetrLadunkowy())
                    .wyposazenie(gieldaPojazdowDTO.getWyposazenie())
                    .stawka(gieldaPojazdowDTO.getStawka())
                    .waluta(gieldaPojazdowDTO.getWaluta())
                    .build();

            gieldaPojazdowService.dodajDoGielbyPojazdow(gieldaPojazdow);
            return "Dodałem rekort do Giełda Pojazdów";
        } else {
            return "Nie ma przewoznika z email: " + gieldaPojazdowDTO.getPrzewoznikEmail();
        }
    }
}
