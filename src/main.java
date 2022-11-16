import Models.Height;
import Models.Location;
import Models.PlaneDb;
import Services.CoordinateService;

public class main {
    public static void main(String[] args){
        PlaneDb db = new PlaneDb();
        CoordinateService coordinateService = new CoordinateService();
        Location location1 = new Location(38.8976, -77.0366, "","");
        Location location2 = new Location(39.9496, -75.1503, "","");
        System.out.println(coordinateService.findDistance(location1, location2, 6.371));
    }
}
