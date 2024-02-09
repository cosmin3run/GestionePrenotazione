package epicode.GestionePrenotazione;

import com.github.javafaker.Faker;
import epicode.GestionePrenotazione.entities.Building;
import epicode.GestionePrenotazione.entities.Reservation;
import epicode.GestionePrenotazione.entities.Station;
import epicode.GestionePrenotazione.entities.User;
import epicode.GestionePrenotazione.service.BuildingsService;
import epicode.GestionePrenotazione.service.ReservationsService;
import epicode.GestionePrenotazione.service.StationsService;
import epicode.GestionePrenotazione.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class Runner implements CommandLineRunner {
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
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(GestionePrenotazioneApplication.class);
        Faker faker = new Faker();
        //Save User
//        User user1 = new User(faker.name().username(), faker.name().firstName(),faker.name().lastName(),faker.internet().emailAddress());
//        User user2 = new User(faker.name().username(), faker.name().firstName(),faker.name().lastName(),faker.internet().emailAddress());
//        User user3 = new User(faker.name().username(), faker.name().firstName(),faker.name().lastName(),faker.internet().emailAddress());
//        usersService.saveUser(user1);
//        usersService.saveUser(user2);
//        usersService.saveUser(user3);
//        //SaveBuilding
//        Building building1 = new Building(faker.company().name(), faker.address().fullAddress(), faker.address().cityName() );
//        Building building2 = new Building(faker.company().name(), faker.address().fullAddress(), faker.address().cityName() );
//        Building building3 = new Building(faker.company().name(), faker.address().fullAddress(), faker.address().cityName() );
//        buildingsService.saveBuilding(building1);
//        buildingsService.saveBuilding(building2);
//        buildingsService.saveBuilding(building3);
//        //Save Station
//        Station station1 = new Station("Big windows, nice view, first floor with lift.", StationType.OPENSPACE,50,building1);
//        Station station2 = new Station("Bunker 3 floors under the earth, luxury antinuclear meeting room", StationType.MEETINGROOM,100,building1);
//        Station station3 = new Station("Small and smelly suburb place, fine for students", StationType.PRIVATE,10,building2);
//        Station station4 = new Station("Small and smelly suburb place, fine for students. Just next floor", StationType.PRIVATE,10,building2);
//
//        stationsService.saveStation(station1);
//        stationsService.saveStation(station2);
//        stationsService.saveStation(station3);
//        stationsService.saveStation(station4);
//        //Save Reservation
//        Reservation reservation1 = new Reservation(user1, LocalDate.now().plusMonths(1), station1);
//        Reservation reservation2 = new Reservation(user2, LocalDate.now().plusMonths(1), station2);
//        Reservation reservation3 = new Reservation(user2, LocalDate.now().plusMonths(1), station3);
//        Reservation reservation4 = new Reservation(user1, LocalDate.now().plusMonths(1), station4);
//        Reservation reservation5 = new Reservation(user3, LocalDate.now().plusMonths(1).plusDays(2), station1);
//        Reservation reservation6 = new Reservation(user3, LocalDate.now().plusMonths(1).plusDays(1), station2);
//        Reservation reservation7 = new Reservation(user1, LocalDate.now().plusMonths(1).plusDays(2), station3);
//        reservationsService.saveReservation(reservation1);
//        reservationsService.saveReservation(reservation2);
//        reservationsService.saveReservation(reservation3);
//        reservationsService.saveReservation(reservation4);
//        reservationsService.saveReservation(reservation5);
//        reservationsService.saveReservation(reservation6);
//        reservationsService.saveReservation(reservation7);

        //SAVING USERS
        User user1 = (User) ctx.getBean("user1");
        usersService.saveUser(user1);
        User user2 = (User) ctx.getBean("user2");
        usersService.saveUser(user2);
        User user3 = (User) ctx.getBean("user3");
        usersService.saveUser(user3);
        //SAVING BUILDINGS
        Building building1 = (Building) ctx.getBean("building1");
        buildingsService.saveBuilding(building1);
        Building building2 = (Building) ctx.getBean("building2");
        buildingsService.saveBuilding(building2);
        Building building3 = (Building) ctx.getBean("building3");
        buildingsService.saveBuilding(building3);
        //SAVING STATIONS
        Station station1 = (Station) ctx.getBean("station1");
        stationsService.saveStation(station1);
        Station station2 = (Station) ctx.getBean("station1");
        stationsService.saveStation(station2);
        Station station3 = (Station) ctx.getBean("station1");
        stationsService.saveStation(station3);
        Station station4 = (Station) ctx.getBean("station1");
        stationsService.saveStation(station4);
        //MAKING RESERVATIONS



        Reservation reservation1 = new Reservation(user1, LocalDate.now().plusMonths(1), station1);

        reservationsService.saveReservation(reservation1);

        Reservation reservation2 = new Reservation(user2, LocalDate.now().plusMonths(1), station2);
        reservationsService.saveReservation(reservation2);

        Reservation reservation3 = new Reservation(user2, LocalDate.now().plusMonths(1), station3);
        reservationsService.saveReservation(reservation3);

        Reservation reservation4 = new Reservation(user1, LocalDate.now().plusMonths(1), station4);
        reservationsService.saveReservation(reservation4);

        Reservation reservation5 = new Reservation(user3, LocalDate.now().plusMonths(1).plusDays(2), station1);
        reservationsService.saveReservation(reservation5);

        Reservation reservation6 = new Reservation(user3, LocalDate.now().plusMonths(1).plusDays(1), station2);
        reservationsService.saveReservation(reservation6);

        Reservation reservation7 = new Reservation(user1, LocalDate.now().plusMonths(1).plusDays(2), station3);
        reservationsService.saveReservation(reservation7);

        //Save reservation in used station and day
        Reservation reservation8 = new Reservation(user1, LocalDate.now().plusMonths(1).plusDays(2), station3);
        reservationsService.saveReservation(reservation8);
        //

    }


}
