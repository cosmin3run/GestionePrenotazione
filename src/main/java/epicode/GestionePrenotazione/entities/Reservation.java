package epicode.GestionePrenotazione.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@ToString

public class Reservation {
    private int id;
    private User user;
    private LocalDate startReservation;
    private LocalDate endReservation;

    private Station station;
}
