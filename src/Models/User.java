package Models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class User {
    private String id;
    private String firstName;
    private String lastName;
    private List<Ticket> tickets;

    public User(){
        setId();
        setTickets(new ArrayList<>());
        setFirstName("null");
        setLastName("null");
    }

    public User(String firstName, String lastName, List<Ticket> tickets) {
        setTickets(tickets);
        setLastName(lastName);
        setFirstName(firstName);
    }

    private void setId(){
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Ticket> getTickets() {
        return List.copyOf(this.tickets);
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = List.copyOf(this.tickets);
    }

}
