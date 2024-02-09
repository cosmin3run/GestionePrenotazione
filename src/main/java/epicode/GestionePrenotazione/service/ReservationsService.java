package epicode.GestionePrenotazione.service;

import epicode.GestionePrenotazione.DAO.ReservationsDAO;
import epicode.GestionePrenotazione.entities.Reservation;
import epicode.GestionePrenotazione.exceptions.ItemNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@Slf4j
public class ReservationsService {

    @Autowired
    private ReservationsDAO reservationsDAO;

    public void saveReservation(Reservation newReservation){
        reservationsDAO.save(newReservation);
        log.info("Reservation booked");
    }

    public Reservation findById(int reservationId) throws ItemNotFoundException{
        return reservationsDAO.findById(reservationId).orElseThrow(ItemNotFoundException::new);
    }

    public void findByIdAndUpdate(int reservationId, Reservation updatedReservation){
        Reservation found = this.findById(reservationId);
        found.setStation(updatedReservation.getStation());
        found.setUser(updatedReservation.getUser());
        found.setStartReservation(updatedReservation.getStartReservation());
    }

    public void findByIdAndDelete(int reservationId){
        Reservation found = this.findById(reservationId);
        reservationsDAO.delete(found);
        log.info("This reservation has been deleted.");
    }
}
