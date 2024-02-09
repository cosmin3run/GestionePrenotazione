package epicode.GestionePrenotazione.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@ToString
@NoArgsConstructor

@Entity
@Table(name = "buildings")

public class Building {

    private int id;
    private String name;
    private String address;
    private String city;
    private List<Station> stations;
}
