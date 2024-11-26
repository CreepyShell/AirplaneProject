package DAL.Models.Plane.FactoryMethod;

import DAL.Models.Height;
import DAL.Models.Location;
import DAL.Models.Plane.CargoPlane;
import DAL.Models.Plane.Plane;

import java.util.ArrayList;

public class CargoCreator extends PlaneCreator {
    @Override
    public Plane createPlane(Location location) {
        double maxGoodsWeight = 40000;
        double volume = 200;
        this.maxAmountOfSeats = 5;
        this.maxFlyDistance = 30000;
        return new CargoPlane(this.maxAmountOfSeats, location, this.speed, new ArrayList<>(), Height.height6, maxGoodsWeight, volume, maxFlyDistance, name);
    }
}
