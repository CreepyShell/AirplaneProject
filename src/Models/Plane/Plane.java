package Models.Plane;

import Models.Height;
import Models.Location;
import Models.Route;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class Plane {
    private String id;
    private int maxAmountOfSeats;
    private Location location;
    private double speed;
    private List<Route> routes;
    private Height height;

    public Plane() {
        setHeight(Height.height1);
        setRoutes(new ArrayList<>());
        setSpeed(0);
        setMaxAmountOfSeats(2);
    }

    public Plane(int maxAmountOfSeats, Location location, double speed, List<Route> routes, Height height) {
        setId();
        setMaxAmountOfSeats(maxAmountOfSeats);
        setLocation(location);
        setSpeed(speed);
        setRoutes(routes);
        setHeight(height);
    }

    public String getId() {
        return id;
    }

    public void setId() {
        this.id = UUID.randomUUID().toString();
    }

    public int getMaxAmountOfSeats() {
        return maxAmountOfSeats;
    }

    public abstract void setMaxAmountOfSeats(int maxAmountOfSeats);

    public Location getLocation() {
        return new Location(location.getX(), location.getY(), location.getCity(), location.getCountry());
    }

    public void setLocation(Location location) {
        this.location = new Location(location.getX(), location.getY(), location.getCity(), location.getCountry());
    }

    public double getSpeed() {
        return speed;
    }

    public abstract void setSpeed(double speed);

    public List<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }

    public Height getHeight() {
        return height;
    }

    public void setHeight(Height height) {
        this.height = height;
    }
}