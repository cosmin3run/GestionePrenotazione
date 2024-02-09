package epicode.GestionePrenotazione.DAO;

import epicode.GestionePrenotazione.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersDAO extends JpaRepository<User, Integer> {
    boolean existsByEmail(String email);
}
