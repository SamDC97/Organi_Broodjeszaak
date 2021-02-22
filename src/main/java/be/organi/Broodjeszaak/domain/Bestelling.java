package be.organi.Broodjeszaak.domain;

import be.organi.Broodjeszaak.interfaces.Beleg;
import be.organi.Broodjeszaak.interfaces.Brood;
import be.organi.Broodjeszaak.interfaces.Saus;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Bestelling {

    @Id
    @GeneratedValue
    private Long id;
    private LocalDate datum;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "broodsoort", column = @Column(name = "broodsoort")),
            @AttributeOverride(name = "prijs", column = @Column(name = "brood_prijs"))
    })

    private Brood brood;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "belegsoort", column = @Column(name = "beleg_soort")),
            @AttributeOverride(name = "prijs", column = @Column(name = "beleg_prijs"))
    })
    private Beleg beleg;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "sausSoort", column = @Column(name = "saus_soort")),
            @AttributeOverride(name = "prijs", column = @Column(name = "saus_prijs"))
    })
    private Saus saus;
    private boolean smos;
    private Double prijs;
    private BestellingStatus status;
}
