package Services;

import Interfaces.ICoordinateService;
import Models.Circle;
import Models.Location;

public class CoordinateService implements ICoordinateService {
    @Override
    public double findDistance(Location start, Location end, double radius) {
        double startPointX = start.getLatitude() * Math.PI / 180.0;
        double startPointY = start.getLongitude() * Math.PI / 180.0;
        double endPointX = end.getLatitude() * Math.PI / 180.0;
        double endPointY = end.getLongitude() * Math.PI / 180.0;

        double firstStatement = Math.pow(Math.sin(endPointX / 2 - startPointX / 2), 2);
        double secondStatement = Math.cos(startPointX) * Math.cos(endPointX)
                * Math.pow(Math.sin(endPointY / 2 - startPointY / 2), 2);

        return 2 * radius * Math.asin(Math.sqrt(firstStatement + secondStatement));
    }

    @Override
    public Circle buildCircle(Location start, Location end, double radius) {
        return null;
    }

    @Override
    public Location findCirclesIntersection(Circle first, Circle second) {
        return null;
    }
}
