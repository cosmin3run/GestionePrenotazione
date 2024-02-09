package epicode.GestionePrenotazione.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Setter
@Getter
@ToString
@NoArgsConstructor

@Entity
@Table(name = "buildings")

public class Building {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Setter(AccessLevel.NONE)
    private int id;
    private String name;
    private String address;
    private String city;

    @OneToMany(mappedBy = "building", cascade = CascadeType.REMOVE)
    private List<Station> stations;
}
