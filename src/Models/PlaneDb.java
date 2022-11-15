package Models;

import Models.Plane.Plane;

import java.util.ArrayList;
import java.util.List;

public class PlaneDb {

    public PlaneDb() {
        planes = new ArrayList<>();
        routes = new ArrayList<>();
        tickets = new ArrayList<>();
        users = new ArrayList<>();
    }

    public PlaneDb(List<Plane> planes, List<Route> routes, List<Ticket> tickets, List<User> users) {
        setPlanes(planes);
        setRoutes(routes);
        setTickets(tickets);
        setUsers(users);
    }

    List<Plane> planes;
    List<Route> routes;
    List<Ticket> tickets;
    List<User> users;

    public List<Plane> getPlanes() {
        return planes;
    }

    public void setPlanes(List<Plane> planes) {
        this.planes = planes;
    }

    public List<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
