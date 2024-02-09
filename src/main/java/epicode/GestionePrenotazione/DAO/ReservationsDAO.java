package epicode.GestionePrenotazione.DAO;

import epicode.GestionePrenotazione.entities.Building;
import epicode.GestionePrenotazione.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface ReservationsDAO extends JpaRepository<Reservation, Integer> {

}