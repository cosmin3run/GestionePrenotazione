package epicode.GestionePrenotazione.service;

import epicode.GestionePrenotazione.DAO.BuildingsDAO;
import epicode.GestionePrenotazione.DAO.ReservationsDAO;
import epicode.GestionePrenotazione.DAO.StationsDAO;
import epicode.GestionePrenotazione.DAO.UsersDAO;
import epicode.GestionePrenotazione.entities.User;
import epicode.GestionePrenotazione.exceptions.ItemNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UsersService {
    @Autowired
    private UsersDAO usersDAO;


    public void saveUser(User newUser){
        if (this.existsByEmail(newUser.getEmail())){
            throw new RuntimeException("The user with " + newUser.getEmail()+ " is already registered");
        }else {
            usersDAO.save(newUser);
            log.info("User saved with id: "+ newUser.getId());
        }
    }

    public User findById(int userId) throws ItemNotFoundException {
        return usersDAO.findById(userId).orElseThrow(() -> new ItemNotFoundException(userId));
    }

    public void findByIdAndUpdate(int userId, User updatedUser){
        User found = this.findById(userId);
        found.setUsername(updatedUser.getUsername());
        found.setName(updatedUser.getName());
        found.setUsername(updatedUser.getUsername());
        found.setEmail(updatedUser.getEmail());
        usersDAO.save(found);
        log.info("User with id: " + userId + " has been updated");
    }

    public void findByIdAndDelete(int userId) {
        User found = this.findById(userId);
        usersDAO.delete(found);
        log.info("User with id: " + userId + " has been deleted successfully!");
    }

    public boolean existsByEmail(String email){return usersDAO.existsByEmail(email);}
}
