package shop.repositories;

import org.springframework.stereotype.Repository;
import shop.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {
}
