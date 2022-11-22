import Models.Location;
import Models.PlaneDb;
import Services.FileService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        try {
            FileService file = new FileService();
            PlaneDb db = new PlaneDb(file);
            Gson json = new GsonBuilder().setPrettyPrinting().create();
            System.out.println(db.getLocations().size());
            String locations = json.toJson(db.getLocations(), new TypeToken<ArrayList<Location>>(){}.getType());
            file.writeInFile(locations,"locations.json");

            String resJson = file.readFromFile("locations.json");

            Location[] locations2 = json.fromJson(resJson, Location[].class);

            System.out.println(locations2.length);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }
}
