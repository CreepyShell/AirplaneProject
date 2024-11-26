package DAL.Models.Plane.FactoryMethod;

import DAL.Models.Height;
import DAL.Models.Location;
import DAL.Models.Plane.Plane;
import DAL.Models.Route;

import java.util.List;

public abstract class PlaneCreator {
    protected Height height = Height.height6;
    protected int maxAmountOfSeats = 300;
    protected  double speed = 900;
    protected double maxFlyDistance = 10000;
    protected String name = "Test plain";
    public abstract Plane createPlane(Location location);
}
