package CustomExceptions;

public class TicketException extends RuntimeException{
    public TicketException(String message){
        super(message);
    }
}
