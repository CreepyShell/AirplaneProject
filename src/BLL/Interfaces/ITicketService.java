package BLL.Interfaces;

import DAL.Models.Location;
import DAL.Models.Route;
import DAL.Models.Ticket;
import DAL.Models.User;

public interface ITicketService {
    Ticket buyTicket(User user, Route route);

    Ticket rescheduleTrip(User user, Ticket ticket, Route otherRoute);

    boolean cancelTicket(User user, Ticket ticket);
    Ticket getTicketById(String id);

    Ticket[] buildTrip(Location startLocation, Location endLocation);
    Ticket[] getTicketsByUserId(String userId);
}
