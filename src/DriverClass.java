import BLL.Interfaces.*;
import BLL.Services.*;
import BLL.Services.AuthDecorator.LogDecorator;
import DAL.Models.PlaneDb;
import DAL.Models.User;
import DAL.Repositories.UserRepository;
import PAL.WindowsManager;
import org.json.JSONException;


public class DriverClass {

    private static PlaneDb planeDb;
    private static IFileService fileService;
    private static ITicketService ticketService;
    private static IRouteService routeService;
    private static IAuthenticationService authService;
    private static ILocationService locationService;
    private static User currentUser = new User();

    public static void main(String[] args) throws JSONException {
        fileService = new FileService();
        planeDb = PlaneDb.getPlainDb(fileService);
        ticketService = new TicketService(planeDb);
        locationService = new LocationService(planeDb);
        routeService = new RouteService(planeDb, locationService);
        UserRepository userRepository = new UserRepository(planeDb);
        authService = new AuthenticationService(userRepository);
        LogDecorator logDecorator = new LogDecorator();
        logDecorator.setAuthService(authService);
        WindowsManager windowsManager = WindowsManager.getInstance(currentUser, ticketService, routeService, locationService, logDecorator);
        windowsManager.openIntroductionWindow();
    }
}
