package CustomExceptions;

public class RouteException extends RuntimeException{
    public RouteException(String message){
        super(message);
    }
}
