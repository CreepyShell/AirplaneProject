package Services;

import Interfaces.IRouteService;
import Models.Location;
import Models.PlaneDb;
import Models.Route;
import org.json.JSONException;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.Objects;

public class RouteService implements IRouteService {
    private final PlaneDb db;

    public RouteService(PlaneDb db) {
        this.db = db;
    }

    @Override
    public boolean addRoute(Route route) {
        if (route == null)
            throw new InvalidParameterException("route is null");

        List<Route> routes = db.getRoutes();
        double distance = this.findDistance(route.getTakeOffLocation(), route.getLandingLocation(), 6371000);
        double flyMinutes = distance / route.getPlane().getSpeed();
        for (Route r : routes) {
            //ensure a plane is available
            boolean isAppropriateLandingTime = Math.abs(route.getTakeOffTime().getTime() - r.getTakeOffTime().getTime()) / (1000.0 * 60) > 25;
            boolean isAppropriateTakingOffTime = Math.abs((route.getTakeOffTime().getTime() - r.getTakeOffTime().getTime()) / (1000.0 * 60) + flyMinutes) > 25;
            if (!isAppropriateTakingOffTime || !isAppropriateLandingTime)
                return false;
        }

        routes.add(route);
        try {
            db.setRoutes(routes);
        } catch (JSONException e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean updateRoute(Route route) {
        return false;
    }

    @Override
    public boolean deleteRoute(Route route) {
        return false;
    }

    @Override
    public double findDistance(Location start, Location end, double radius) {
        double startPointX = Math.toRadians(start.getLatitude());
        double startPointY = Math.toRadians(start.getLongitude());
        double endPointX = Math.toRadians(end.getLatitude());
        double endPointY = Math.toRadians(end.getLongitude());

        double firstStatement = Math.pow(Math.sin(endPointX / 2 - startPointX / 2), 2);
        double secondStatement = Math.cos(startPointX) * Math.cos(endPointX)
                * Math.pow(Math.sin(endPointY / 2 - startPointY / 2), 2);

        return 2 * radius * Math.asin(Math.sqrt(firstStatement + secondStatement));
    }

    @Override
    public List<Route> findBestRoutesByPrice(Location start, Location end) {
        List<Route> routesLocation = this.findRoutesByLocation(start, end);
        //sort by price
        return routesLocation;
    }

    @Override
    public List<Route> findBestRoutesByTime(Location start, Location end) {
        List<Route> routesLocation = this.findRoutesByLocation(start, end);
        //sort by time
        return routesLocation;
    }

    @Override
    public List<Route> findRoutesByLocation(Location startLocation, Location endLocation) {
        return db.getRoutes().stream().filter(r -> Objects.equals(r.getTakeOffLocation().getCity(), startLocation.getCity()) &&
                Objects.equals(r.getLandingLocation().getCity(), endLocation.getCity())).toList();
    }
}
