package entities;

public class Ticket {

    private String messageText;
    private String priority;
    private String ticketStatus;
    private int userID;
    private int ticketID;

    public Ticket(String messageText, String priority, String ticketStatus, int userID) {
        this.messageText = messageText;
        this.priority = priority;
        this.ticketStatus = ticketStatus;
        this.userID = userID;
    }

    public Ticket(String messageText, String priority, String ticketStatus, int userID, int ticketID) {
        this.messageText = messageText;
        this.priority = priority;
        this.ticketStatus = ticketStatus;
        this.userID = userID;
        this.ticketID = ticketID;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(String ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getTicketID() {
        return ticketID;
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
