package epicode.GestionePrenotazione;

import com.github.javafaker.Faker;
import epicode.GestionePrenotazione.entities.User;
import epicode.GestionePrenotazione.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UsersRunner implements CommandLineRunner {
    @Autowired
    UsersService usersService;


    @Override
    public void run(String... args) throws Exception {
        Faker faker = new Faker();
        User newUser = new User(faker.name().username(), faker.name().firstName(),faker.name().lastName(),faker.internet().emailAddress());
        usersService.saveUser(newUser);
    }
}
