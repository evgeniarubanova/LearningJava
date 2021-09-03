package shop.entities;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "cart")
public class Cart {

    @Id
    @Column(name = "purchase_id")
    private Integer purchaseID;

    @Column(name = "purchase_amount")
    private Integer purchaseAmount;

}
