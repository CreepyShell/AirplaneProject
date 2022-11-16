package Interfaces;

import Models.Circle;
import Models.Location;

public interface ICoordinateService {
    double findDistance(Location start, Location end, double radius);
    Circle buildCircle(Location start, Location end, double radius);
    Location findCirclesIntersection(Circle first, Circle second);
}
