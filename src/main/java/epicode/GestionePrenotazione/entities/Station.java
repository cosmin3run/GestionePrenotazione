package epicode.GestionePrenotazione.entities;

import epicode.GestionePrenotazione.enums.StationType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor

public class Station {
    private int id;
    private String description;
    private StationType stationType;
    private int maxOccupants;
    private Building building;
}
