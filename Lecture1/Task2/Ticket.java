public class Ticket{
    int ticketId;
    String question;

    public Ticket(int ticketId, String question){
        this.ticketId = ticketId;
        this.question = question;
    }

    public int getTicketId(){
        return ticketId;
    }

}