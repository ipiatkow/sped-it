package pl.paraklet.sped_it.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.paraklet.sped_it.model.enums.TypPojazdu;


import java.time.LocalDate;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
//@Builder
@Entity
public class GieldaLadunkow {

    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private Lokalizacja miejsceZaladunku;
    @ManyToOne
    private Lokalizacja miejsceRozladunku;
    private TypPojazdu typPojazdu1;
    private TypPojazdu typPojazdu2;
    private TypPojazdu typPojazdu3;
    private float ladownosc;
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

}
