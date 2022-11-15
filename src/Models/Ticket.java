package Models;

import java.util.Date;
import java.util.UUID;

public class Ticket {
    private String id;
    private Date dateBought;
    private Date dateReschedule;
    private User user;
    private Route route;
    private double cost;

    public Ticket(){
    setId();
    }

    public Ticket(Date dateBought, User user, Route route, double cost) {
        setId();
        setDateBought(dateBought);
        setDateReschedule(dateBought);
        setUser(user);
        setRoute(route);
        setCost(cost);
    }

    public String getId() {
        return this.id;
    }

    private void setId() {
        this.id = id;
    }

    public Date getDateBought() {
        return dateBought;
    }

    public void setDateBought(Date dateBought) {
        this.dateBought = dateBought;
    }

    public Date getDateReschedule() {
        return dateReschedule;
    }

    public void setDateReschedule(Date dateReschedule) {
        this.dateReschedule = dateReschedule;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
