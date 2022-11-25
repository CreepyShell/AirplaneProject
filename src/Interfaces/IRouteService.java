package Interfaces;

import Models.Location;
import Models.Plane.Plane;
import Models.Route;

import java.util.List;

public interface IRouteService {
    boolean addRoute(Route route);
    boolean updateRoute(Route route);
    boolean deleteRoute(Route route);
    List<Plane> getAllPlanes();
    List<Route> getAllRoutes();
    Plane getPlaneByName(String name);
    Route getRouteById(String id);
    List<Route> findBestRoutesByPrice(Location start, Location end);
    List<Route> findBestRoutesByTime(Location start, Location end);
    List<Route> findRoutesByLocation(Location startLocation, Location endLocation);
}
