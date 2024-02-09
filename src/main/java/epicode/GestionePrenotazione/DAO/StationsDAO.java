package epicode.GestionePrenotazione.DAO;

import epicode.GestionePrenotazione.entities.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StationsDAO extends JpaRepository<Station, Integer> {
}
