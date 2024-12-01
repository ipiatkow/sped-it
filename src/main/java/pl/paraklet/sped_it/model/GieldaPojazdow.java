package pl.paraklet.sped_it.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.paraklet.sped_it.model.enums.TypPojazdu;
import pl.paraklet.sped_it.model.enums.Waluta;

import java.time.LocalDate;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class GieldaPojazdow {

    @Id
    @GeneratedValue
    private Long id;
    @OneToOne
    private Lokalizacja miejsceZaladunku;
    @OneToMany
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
    @OneToOne
    private Firma przewoznik;

}
