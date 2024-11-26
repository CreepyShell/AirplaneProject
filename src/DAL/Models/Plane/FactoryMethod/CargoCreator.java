package DAL.Models.Plane.FactoryMethod;

import DAL.Models.Height;
import DAL.Models.Location;
import DAL.Models.Plane.Plane;
import DAL.Models.Plane.CargoPlane;
import DAL.Models.Route;

import java.util.ArrayList;
import java.util.List;

public class CargoCreator extends PlaneCreator {
    @Override
    public Plane createPlane(Location location) {
        double maxGoodsWeight = 2000;
        double volume = 200;
        return new CargoPlane(300, location, 900, new ArrayList<>(), Height.height6, maxFlyDistance, maxGoodsWeight, volume, name);
    }
}
