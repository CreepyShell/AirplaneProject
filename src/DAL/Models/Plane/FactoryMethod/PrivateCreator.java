package DAL.Models.Plane.FactoryMethod;

import DAL.Models.Location;
import DAL.Models.Plane.Plane;
import DAL.Models.Plane.PrivatePlane;
import DAL.Models.Route;

import java.util.ArrayList;
import java.util.List;

public class PrivateCreator extends PlaneCreator{
    @Override
    public Plane createPlane(Location location) {
        return new PrivatePlane(maxAmountOfSeats,location, speed, new ArrayList<>(), height, maxFlyDistance, name);
    }
}
