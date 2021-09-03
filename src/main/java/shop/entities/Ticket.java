package shop.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ticket")
public class Ticket {

    @Id
    @Column(name = "ticket_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ticketID;

    @Column(name = "message_text")
    private String messageText;

    @Column(name = "priority")
    private String priority;

    @Column(name = "ticket_status")
    private String ticketStatus;

    @Column(name = "user_id")
    private int userID;

    public Ticket(String messageText, String priority, String ticketStatus, int userID) {
        this.messageText = messageText;
        this.priority = priority;
        this.ticketStatus = ticketStatus;
        this.userID = userID;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "messageText='" + messageText + '\'' +
                ", priority='" + priority + '\'' +
                ", ticketStatus='" + ticketStatus + '\'' +
                ", userID=" + userID +
                '}';
    }
}
