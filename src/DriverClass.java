import Interfaces.*;
import Models.PlaneDb;
import Models.User;
import Services.*;
import Windows.*;
import org.json.JSONException;

import javax.swing.*;
import java.awt.*;
import java.text.ParseException;

public class DriverClass {

    private static PlaneDb planeDb;
    private static IFileService fileService;
    private static ITicketService ticketService;
    private static IRouteService routeService;
    private static IAuthenticationService authService;
    private static ILocationService locationService;
    private static User currentUser = new User();

    public static void main(String[] args) throws ParseException, JSONException {
        fileService = new FileService();
        planeDb = new PlaneDb(fileService);
        ticketService = new TicketService(planeDb);
        locationService = new LocationService(planeDb);
        routeService = new RouteService(planeDb, locationService);
        authService = new AuthenticationService(planeDb);
        RoutesWindow mainMenu = new RoutesWindow(routeService);
    }
}
