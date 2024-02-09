package epicode.GestionePrenotazione.DAO;

import epicode.GestionePrenotazione.entities.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildingsDAO extends JpaRepository<Building, Integer> {
    boolean existsByAddress(String address);
}
