package Services;

import Interfaces.ILocationService;
import Interfaces.IRouteService;
import Models.Location;
import Models.PlaneDb;
import Models.Route;
import org.json.JSONException;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RouteService implements IRouteService {
    private final PlaneDb db;
    private final ILocationService locationService;

    public RouteService(PlaneDb db, ILocationService locationService) {
        this.db = db;
        this.locationService = locationService;
    }

    @Override
    public boolean addRoute(Route route) {
        if (route == null)
            throw new InvalidParameterException("route is null");

        List<Route> routes = db.getRoutes();
        double distance = this.locationService.findDistance(route.getTakeOffLocation(), route.getLandingLocation(), 6371000);
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
    public List<Route> findBestRoutesByPrice(Location start, Location end) {
        List<Route> routesLocation = this.findRoutesByLocation(start, end);
        for (int i = 0; i < routesLocation.size(); i++) {
            for (int j = 1; j < routesLocation.size(); j++) {
                Route route1 = routesLocation.get(i);
                Route route2 = routesLocation.get(j);
                if (routesLocation.get(j).getCost() < routesLocation.get(i).getCost()) {
                    routesLocation.set(j, route1);
                    routesLocation.set(i, route2);
                }
            }
        }
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
        if(startLocation==null || endLocation==null){
            return new ArrayList<>();
        }
        return db.getRoutes().stream().filter(r -> Objects.equals(r.getTakeOffLocation().getCity(), startLocation.getCity()) &&
                Objects.equals(r.getLandingLocation().getCity(), endLocation.getCity())).toList();
    }
}
