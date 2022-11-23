package Services;

import Interfaces.IRouteService;
import Models.Location;
import Models.PlaneDb;
import Models.Route;

import java.util.List;

public class RouteService implements IRouteService {
    private final PlaneDb db;

    public RouteService(PlaneDb db) {
        this.db = db;
    }

    @Override
    public boolean addRoute(Route route) {
        return false;
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
        return null;
    }

    @Override
    public List<Route> findBestRoutesByTime(Location start, Location end) {
        return null;
    }

    @Override
    public List<Route> findRoutesByLocation(Location startLocation, Location endLocation) {
        return db.getRoutes().stream().filter(r -> r.getTakeOffLocation().getCity() == startLocation.getCity() &&
                r.getLandingLocation().getCity() == endLocation.getCity()).toList();
    }
}
