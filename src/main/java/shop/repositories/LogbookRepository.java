package shop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shop.entities.Logbook;

import java.util.List;

@Repository
public interface LogbookRepository extends JpaRepository<Logbook, Integer> {

}
