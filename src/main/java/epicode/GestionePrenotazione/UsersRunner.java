package epicode.GestionePrenotazione;

import com.github.javafaker.Faker;
import epicode.GestionePrenotazione.entities.Building;
import epicode.GestionePrenotazione.entities.Reservation;
import epicode.GestionePrenotazione.entities.Station;
import epicode.GestionePrenotazione.entities.User;
import epicode.GestionePrenotazione.enums.StationType;
import epicode.GestionePrenotazione.service.BuildingsService;
import epicode.GestionePrenotazione.service.ReservationsService;
import epicode.GestionePrenotazione.service.StationsService;
import epicode.GestionePrenotazione.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class UsersRunner implements CommandLineRunner {
    @Autowired
    UsersService usersService;

    @Autowired
    BuildingsService buildingsService;

    @Autowired
    StationsService stationsService;

    @Autowired
    ReservationsService reservationsService;


    @Override
    public void run(String... args) throws Exception {
        Faker faker = new Faker();
        //Save User
        User user1 = new User(faker.name().username(), faker.name().firstName(),faker.name().lastName(),faker.internet().emailAddress());
        usersService.saveUser(user1);
        //SaveBuilding
        Building building1 = new Building(faker.company().name(), faker.address().fullAddress(), faker.address().cityName() );
        buildingsService.saveBuilding(building1);
        //Save Station
        Station station1 = new Station("Big windows, nice view, first floor with lift.", StationType.OPENSPACE,50,building1);
        stationsService.saveStation(station1);
        //Save Reservation
        Reservation reservation = new Reservation(user1, LocalDate.now().plusMonths(1), station1);
        reservationsService.saveReservation(reservation);
    }
}
