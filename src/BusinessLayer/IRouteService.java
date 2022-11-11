package BusinessLayer;

import DataLayer.Location;
import DataLayer.Route;

import java.util.List;

public interface IRouteService {
    boolean addRoute(Route route);
    boolean updateRoute(Route route);
    boolean deleteRoute(Route route);
    List<Route> findBestRoutesByPrice(Location start, Location end);
    List<Route> findBestRoutesByTime(Location start, Location end);
    Route findRouteByLocation(Location location);
}
