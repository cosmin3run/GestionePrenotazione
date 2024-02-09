package epicode.GestionePrenotazione;

import epicode.GestionePrenotazione.entities.Reservation;
import epicode.GestionePrenotazione.entities.Station;
import epicode.GestionePrenotazione.entities.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;

public class BookingTests {
    static private AnnotationConfigApplicationContext ctx;
    @BeforeAll
    public static void beforeAll(){
        ctx = new AnnotationConfigApplicationContext(GestionePrenotazioneApplication.class);
    }

    @Test
    public void TestUserReservation(){
        User user1 = (User) ctx.getBean("user1");
        Station station1 = (Station) ctx.getBean("station1");
        Reservation reservationTest = new Reservation(user1, LocalDate.now(), station1);
        assertEquals(user1.id, reservationTest.getUser().id);
    }
}
