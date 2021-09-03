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

    public Logbook(Integer purchaseID, Integer productID, int number) {
        this.purchaseID = purchaseID;
        this.productID = productID;
        this.number = number;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "purchase_id")
    private Integer purchaseID;

    @Column(name = "product_id")
    private Integer productID;

    @Column(name = "number")
    private int number;

}
