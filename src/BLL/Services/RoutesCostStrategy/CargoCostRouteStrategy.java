package BLL.Services.RoutesCostStrategy;

import DAL.Models.Plane.CargoPlane;
import DAL.Models.Route;

import java.security.InvalidParameterException;
import java.time.Duration;
import java.time.Instant;
;

public class CargoCostRouteStrategy implements RoutesCostStrategy {
    @Override
    public Double calculateCost(Route route) {
        if (!(route.getPlane() instanceof CargoPlane)) {
            throw new InvalidParameterException("Invalid plane type provided");
        }

        CargoPlane cargoPlane = (CargoPlane) route.getPlane();
        System.out.println("Calculating the cost of cargo plane route");
        Instant takeOff = route.getTakeOffTime().toInstant();
        Instant land = route.getRandomLandTime().toInstant();

        long duration = Duration.between(takeOff, land).toHours();
        return cargoPlane.getVolume() * duration * Math.sqrt(cargoPlane.getSpeed()) * 1563.34;
    }
}
