package epicode.GestionePrenotazione.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@ToString

@Entity
@Table(name = "users")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Setter(AccessLevel.NONE)
    public int id;

    public String username;

    public String name;

    @Column(name = "last_name")
    public String lastName;

    public String email;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    public List<Reservation> reservation;

    //CONSTRUCTOR


    public User(String username, String name, String lastName, String email) {

        this.username = username;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
    }
}
