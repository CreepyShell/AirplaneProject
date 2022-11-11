package Interfaces;

import Models.Line;
import Models.Location;

public interface ICoordinateService {
    double findDistance(Location start, Location end);
    Line buildLine(Location start, Location end);
    Location findLinesIntersection(Line first, Line second);
}
