package Services;

import Interfaces.ICoordinateService;
import Models.Line;
import Models.Location;

public class CoordinateService implements ICoordinateService {
    @Override
    public double findDistance(Location start, Location end) {
        return 0;
    }

    @Override
    public Line buildLine(Location start, Location end) {
        return null;
    }

    @Override
    public Location findLinesIntersection(Line first, Line second) {
        return null;
    }
}
