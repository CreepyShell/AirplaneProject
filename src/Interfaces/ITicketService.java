package Interfaces;

import Models.*;

public interface ITicketService {
    Ticket buyTicket(User user, Route route);
    Ticket rescheduleTrip(User user, Route otherRoute);
    boolean cancelTicket(User user, Ticket ticket);
    Ticket[] buildTrip(Location startLocation, Location endLocation);
}
