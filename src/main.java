import Models.PlaneDb;
import Models.Route;
import Models.Ticket;
import Models.User;
import Services.FileService;
import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class main {
    public static void main(String[] args) throws IOException, ClassNotFoundException, JSONException {
        FileService fileService = new FileService();

        PlaneDb planeDb = new PlaneDb(fileService);
        List<User> users = planeDb.getUsers();
       User user = users.stream().filter(u->u.getEmail()=="email").findAny().orElse(null);
    }
}
