package epicode.GestionePrenotazione.DAO;

import epicode.GestionePrenotazione.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersDAO extends JpaRepository<User, Integer> {
    boolean existsByEmail(String email);
}
