import Interfaces.IAuthenticationService;
import Interfaces.IFileService;
import Interfaces.IRouteService;
import Interfaces.ITicketService;
import Models.PlaneDb;
import Models.User;
import Services.AuthenticationService;
import Services.FileService;
import Services.RouteService;
import Services.TicketService;
import Windows.AuthWindow;
import Windows.IntroductionWindow;
import Windows.MainMenu;
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
    private static User currentUser = new User();

    public static void main(String[] args) throws ParseException, JSONException {
        fileService = new FileService();
        planeDb = new PlaneDb(fileService);
        ticketService = new TicketService(planeDb);
        routeService = new RouteService(planeDb);
        authService = new AuthenticationService(planeDb);
        MainMenu mainMenu = new MainMenu(ticketService, currentUser);
    }
}
