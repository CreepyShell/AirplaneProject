import Models.PlaneDb;
import Models.User;
import Services.FileService;
import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) throws IOException, ClassNotFoundException, JSONException {
        FileService fileService = new FileService();
        PlaneDb planeDb = new PlaneDb(fileService);
        User user = new User("Admin", "Main", new ArrayList<>(), "simplePassword", "email");
        planeDb.readRoutesFromFile();
        List<User> users = planeDb.getUsers();
        users.add(user);
        planeDb.setUsers(users);
        System.out.println(planeDb.getUsers().size());

    }
}
