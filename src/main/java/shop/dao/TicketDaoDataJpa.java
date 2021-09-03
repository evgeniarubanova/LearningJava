package shop.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.dao.interfaces.TicketDao;
import shop.entities.Ticket;
import shop.repositories.PurchaseRepository;
import shop.repositories.TicketRepository;

import java.util.List;

@Service
public class TicketDaoDataJpa implements TicketDao{

    private TicketRepository ticketRepository;

    @Autowired
    public void setTicketRepository(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public TicketDaoDataJpa() {}

    @Override
    public Ticket getTicketById(Integer id) {
        return ticketRepository.getById(id);
    }

    @Override
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    @Override
    public Ticket addTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    @Override
    public Ticket updateTicket(Ticket ticket) {
        return addTicket(ticket);
    }

    @Override
    public boolean deleteTicketById(Integer id) {
        ticketRepository.deleteById(id);
        return true;
    }
}
