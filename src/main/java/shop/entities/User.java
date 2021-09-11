package shop.entities;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "customer")
public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "address")
    private String address;

    @Column(name = "phone_number")
    private String number;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    public User(String name, String surname, String address, String number, String login, String password) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.number = number;
        this.login = login;
        this.password = password;
    }
}
