package epicode.GestionePrenotazione.entities;

import com.github.javafaker.Faker;
import epicode.GestionePrenotazione.enums.StationType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("application.properties")
public class AppConfig {
    //Faker import
    Faker faker = new Faker();

    //User Bean Creation
    @Bean(name = "user1")
    public User user1(){return new User(faker.name().username(), faker.name().firstName(),faker.name().lastName(),faker.internet().emailAddress());}
     @Bean(name = "user2")
    public User user2(){return new User(faker.name().username(), faker.name().firstName(),faker.name().lastName(),faker.internet().emailAddress());}
     @Bean(name = "user3")
    public User user3(){return new User(faker.name().username(), faker.name().firstName(),faker.name().lastName(),faker.internet().emailAddress());}

    // Building Bean Creation
    @Bean(name = "building1")
    public Building building1(){return new Building(faker.company().name(), faker.address().fullAddress(), faker.address().cityName() );}
    @Bean(name = "building2")
    public Building building2(){return new Building(faker.company().name(), faker.address().fullAddress(), faker.address().cityName() );}
    @Bean(name = "building3")
    public Building building3(){return new Building(faker.company().name(), faker.address().fullAddress(), faker.address().cityName() );}

    //Station Bean Creation
    @Bean(name = "station1")
    public Station station1(){return new Station("Big windows, nice view, first floor with lift.", StationType.OPENSPACE,50,building1());}
@Bean(name = "station2")
    public Station station2(){return new Station("Bunker 3 floors under the earth, luxury antinuclear meeting room", StationType.MEETINGROOM,100,building1());}
@Bean(name = "station3")
    public Station station3(){return new Station("Small and smelly suburb place, fine for students", StationType.PRIVATE,10,building2());}
@Bean(name = "station4")
    public Station station4(){return new Station("Small and smelly suburb place, fine for students. Just next floor", StationType.PRIVATE,10,building2());}

}
