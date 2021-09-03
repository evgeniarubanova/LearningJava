package shop.dao.interfaces;

import shop.entities.Ticket;

import java.util.List;

public interface TicketDao {
    Ticket getTicketById(Integer id);
    List<Ticket> getAllTickets();
    Ticket addTicket(Ticket ticket);
    Ticket updateTicket(Ticket ticket);
    boolean deleteTicketById(Integer id);
}
