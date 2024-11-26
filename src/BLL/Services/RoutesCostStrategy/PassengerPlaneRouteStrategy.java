package BLL.Services.RoutesCostStrategy;

import DAL.Models.Plane.PassengerPlane;
import DAL.Models.Route;

import java.security.InvalidParameterException;
import java.time.Duration;
import java.time.Instant;

public class PassengerPlaneRouteStrategy implements RoutesCostStrategy{
    @Override
    public Double calculateCost(Route route) {
        if (!(route.getPlane() instanceof PassengerPlane)) {
            throw new InvalidParameterException("Invalid plane type provided");
        }
        PassengerPlane passengerPlane = (PassengerPlane) route.getPlane();

        System.out.println("Calculating the cost of passenger plane route");
        Instant takeOff = route.getTakeOffTime().toInstant();
        Instant land = route.getRandomLandTime().toInstant();

        long duration = Duration.between(takeOff, land).toHours();
        return passengerPlane.getMaxAmountOfSeats() * duration * passengerPlane.getSpeed() * 532;
    }
}