package pl.paraklet.sped_it.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.paraklet.sped_it.model.enums.TypPojazdu;


import java.time.LocalDate;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
//@Builder
public class GieldaLadunkow {

    private Lokalizacja miejsceZaladunku;
    private Lokalizacja miejsceRozladunku;
    private TypPojazdu typPojazdu;
    private TypPojazdu typPojazdu2;
    private TypPojazdu typPojazdu3;
    private int multifracht = 0;
    private boolean ftl;
    private boolean ltl;
    private boolean zNaczepa;
    private boolean solo;
    private boolean bus;
    private boolean zPrzyczepa;
    private int cenaPublikacji;
    private int terminPlatnosci;
    private LocalDate dataPublikacji = LocalDate.now();
    @OneToOne
    private Firma firma;

    public GieldaLadunkow(Lokalizacja miejsceZaladunku, Lokalizacja miejsceRozladunku, int multifracht, boolean ftl, boolean ltl, boolean zNaczepa, boolean solo, boolean bus, boolean zPrzyczepa, int cenaPublikacji, int terminPlatnosci, Firma firma) {
        this.miejsceZaladunku = miejsceZaladunku;
        this.miejsceRozladunku = miejsceRozladunku;
        this.multifracht = multifracht;
        this.ftl = ftl;
        this.ltl = ltl;
        this.zNaczepa = zNaczepa;
        this.solo = solo;
        this.bus = bus;
        this.zPrzyczepa = zPrzyczepa;
        this.cenaPublikacji = cenaPublikacji;
        this.terminPlatnosci = terminPlatnosci;
        this.firma = firma;
    }
}
