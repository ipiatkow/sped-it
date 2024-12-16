package pl.paraklet.sped_it.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import lombok.ToString;
import pl.paraklet.sped_it.model.enums.KodPanstwa;




@NoArgsConstructor
@Getter
@Setter
@ToString
//@AllArgsConstructor
@Entity
public class Lokalizacja {
    @Id
    @GeneratedValue
    @JsonIgnore
    private Long id;
    private KodPanstwa kodPanstwa;
    private String kod;
    private String miasto;

    public Lokalizacja(KodPanstwa kodPanstwa, String kod, String miasto) {
        this.kodPanstwa = kodPanstwa;
        this.kod = kod;
        this.miasto = miasto;
    }
}
