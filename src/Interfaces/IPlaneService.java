package Interfaces;

import Models.Location;
import Models.Plane.Plane;
import Models.Route;

import java.util.Date;

public interface IPlaneService {
    Location getPlaneLocation(Date date, Plane plane, Route routeId);
    Plane[] getPlaneWhichIntersectRoute(Route route);
}
