package Models;

import java.util.Arrays;
import java.util.List;

public class User {
    private String id;
    private String firstName;
    private String lastName;

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

    private List<Ticket> tickets;
}
