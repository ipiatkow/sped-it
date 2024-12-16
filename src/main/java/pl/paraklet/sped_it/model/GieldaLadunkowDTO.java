package pl.paraklet.sped_it.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.paraklet.sped_it.model.enums.TypPojazdu;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GieldaLadunkowDTO {

    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private Lokalizacja miejsceZaladunku;
    @ManyToOne
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
    private String firmaEmail;

}
