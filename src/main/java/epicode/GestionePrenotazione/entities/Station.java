package epicode.GestionePrenotazione.entities;

import epicode.GestionePrenotazione.enums.StationType;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "stations")
public class Station {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Setter(AccessLevel.NONE)
    private int id;

    private String description;
    @Enumerated(EnumType.STRING)
    private StationType stationType;
    private int maxOccupants;

    @ManyToOne
    @JoinColumn(name = "building_id")
    private Building building;

    //CONSTRUCTOR

    public Station(String description, StationType stationType, int maxOccupants, Building building) {
        this.description = description;
        this.stationType = stationType;
        this.maxOccupants = maxOccupants;
        this.building = building;
    }
}
