package pl.paraklet.sped_it.model;

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

    private Long id;
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
    private String firmaEmail;

}
