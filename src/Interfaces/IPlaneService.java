package Interfaces;

import Models.Location;
import Models.Plane;
import Models.Route;

import java.util.Date;

public interface IPlaneService {
    Location getPlaneLocation(Date date, Plane plane);
    Plane[] getPlaneIntersectRoute(Route route);
}
