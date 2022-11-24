package CustomExceptions;

public class BalanceException extends RuntimeException {
    public BalanceException(String message){
        super(message);
    }
}
