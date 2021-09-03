package shop.repositories;

import org.springframework.stereotype.Repository;
import shop.entities.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Integer> {
}
