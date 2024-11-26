package DAL.Models;

import BLL.Services.RoutesCostStrategy.RouteCostContext;
import DAL.Models.Plane.Plane;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

public class Route {
    private String id;
    private Date takeOffTime;
    private Location takeOffLocation;
    private Location landingLocation;
    private Plane plane;
    private double cost;

    @Override
    public String toString() {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return "takeOffTime=" + format.format(takeOffTime) +
                ", takeOff:" + takeOffLocation.getCity() +
                ", land:" + landingLocation.getCity() +
                ", plane:" + plane.getName() +
                ", cost:" + cost;
    }

    public Route() {
        setId("");
    }

    public Route(Date takeOffTime, Location takeOffLocation, Location landingLocation, Plane plane, double cost) {
        setId("");
        setTakeOffTime(takeOffTime);
        setTakeOffLocation(takeOffLocation);
        setLandingLocation(landingLocation);
        setPlane(plane);
        setCost(cost);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id.length() == 0) {
            this.id = UUID.randomUUID().toString();
            return;
        }
        this.id = id;
    }

    public Date getTakeOffTime() {
        return takeOffTime;
    }

    public void setTakeOffTime(Date takeOffTime) {
        this.takeOffTime = takeOffTime;
    }

    public Location getTakeOffLocation() {
        return takeOffLocation;
    }

    public void setTakeOffLocation(Location takeOffLocation) {
        this.takeOffLocation = takeOffLocation;
    }

    public Location getLandingLocation() {
        return landingLocation;
    }

    public void setLandingLocation(Location landingLocation) {
        this.landingLocation = landingLocation;
    }

    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Route createCopy() {
        Route route = new Route(this.takeOffTime, this.takeOffLocation, this.landingLocation, this.plane.createCopy(), this.cost);
        route.setId(this.getId());
        return route;
    }

    public Date getRandomLandTime() {
        long oneHourMillis = 60 * 60 * 1000;
        Random random = new Random();
        long randomMillis = oneHourMillis + (long) (random.nextDouble() * 23 * oneHourMillis);
        long newTime = this.getTakeOffTime().getTime() + randomMillis;
        return new Date(newTime);
    }
}
