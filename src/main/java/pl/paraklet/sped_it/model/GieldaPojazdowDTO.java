package pl.paraklet.sped_it.model;

import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import pl.paraklet.sped_it.model.enums.TypPojazdu;
import pl.paraklet.sped_it.model.enums.Waluta;

import java.time.LocalDate;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class GieldaPojazdowDTO {

    private Lokalizacja miejsceZaladunku;
    private Set<Lokalizacja> miejsceRozladunku;
    private LocalDate dostepnoscOd;
    private LocalDate dostepnoscDo;
    private float ladownosc;
    private TypPojazdu typPojazdu;
    private float metrLadunkowy;
    private String wyposazenie;
    private float stawka = 0;
    private Waluta waluta;
    private LocalDate dataZgloszenia;
    private String przewoznikEmail;

}
