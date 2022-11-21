package Interfaces;

import Models.Location;
import Models.Route;

import java.util.List;

public interface IRouteService {
    boolean addRoute(Route route);
    boolean updateRoute(Route route);
    boolean deleteRoute(Route route);
    double findDistance(Location start, Location end, double radius);
    List<Route> findBestRoutesByPrice(Location start, Location end);
    List<Route> findBestRoutesByTime(Location start, Location end);
    List<Route> findRoutesByLocation(Location startLocation, Location endLocation);
}
