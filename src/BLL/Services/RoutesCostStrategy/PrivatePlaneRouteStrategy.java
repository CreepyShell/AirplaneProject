package BLL.Services.RoutesCostStrategy;

import DAL.Models.Plane.PrivatePlane;
import DAL.Models.Route;

import java.security.InvalidParameterException;
import java.time.Duration;
import java.time.Instant;

public class PrivatePlaneRouteStrategy implements RoutesCostStrategy {
    @Override
    public Double calculateCost(Route route) {
        if (!(route.getPlane() instanceof PrivatePlane)) {
            throw new InvalidParameterException("Invalid plane type provided");
        }
        PrivatePlane privatePlane = (PrivatePlane) route.getPlane();

        System.out.println("Calculating the cost of private plane route");
        Instant takeOff = route.getTakeOffTime().toInstant();
        Instant land = route.getRandomLandTime().toInstant();

        long duration = Duration.between(takeOff, land).toHours();
        return privatePlane.getMaxAmountOfSeats() * duration * 15000.0;
    }
}
