package shop.entities;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "logbook")
public class Logbook {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_login")
    private String userLogin;

    @Column(name = "product_id")
    private Integer productID;

    @Column(name = "count")
    private int count;

    public Logbook(String userLogin, Integer productID, int count) {
        this.userLogin = userLogin;
        this.productID = productID;
        this.count = count;
    }

}
