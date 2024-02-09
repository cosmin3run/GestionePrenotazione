package epicode.GestionePrenotazione.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "reservations")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Setter(AccessLevel.NONE)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private LocalDate startReservation;
    private LocalDate endReservation;

    @ManyToOne
    @JoinColumn(name = "station_id")
    private Station station;

    //CONSTRUCTOR

    public Reservation(User user, LocalDate startReservation, Station station) {
        this.user = user;
        this.startReservation = startReservation;
        this.endReservation = startReservation.plusDays(1);
        this.station = station;
    }
}
