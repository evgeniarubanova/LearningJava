package shop.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "purchase")
public class Purchase {

    @Id
    @Column(name = "purchase_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer purchaseID;

    @Column(name = "delivery")
    private String delivery;

    @Column(name = "payment_amount")
    private int paymentAmount;

    @Column(name = "purchase_status")
    private String purchaseStatus;

    @Column(name = "user_id")
    private int userID;

    public Purchase(String delivery, int paymentAmount, String purchaseStatus, int userID) {
        this.delivery = delivery;
        this.paymentAmount = paymentAmount;
        this.purchaseStatus = purchaseStatus;
        this.userID = userID;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "delivery='" + delivery + '\'' +
                ", paymentAmount=" + paymentAmount +
                ", purchaseStatus='" + purchaseStatus + '\'' +
                ", userID=" + userID +
                '}';
    }
}
