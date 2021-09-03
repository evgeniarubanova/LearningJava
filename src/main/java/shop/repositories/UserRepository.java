package shop.repositories;

import org.springframework.stereotype.Repository;
import shop.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
