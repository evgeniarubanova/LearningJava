package shop.entities;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "product")
public class Product {

    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productID;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private int price;

    @Column(name = "category")
    private String category;

    @Column(name = "stock_balance")
    private int stockBalance;

    public Product(String title, String description, int price, String category, int stockBalance) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.category = category;
        this.stockBalance = stockBalance;
    }

}
