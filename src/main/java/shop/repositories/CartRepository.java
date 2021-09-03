package shop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import shop.entities.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {

//    @Query("SELECT c from Cart c where c.purchaseID=:purchase_id")
//    Cart getByPurchaseID(Integer purchaseID);
}
