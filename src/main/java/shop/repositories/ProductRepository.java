package shop.repositories;

import org.springframework.stereotype.Repository;
import shop.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}