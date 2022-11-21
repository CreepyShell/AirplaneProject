package Models;

import Interfaces.IFileService;
import Models.Plane.CargoPlane;
import Models.Plane.PassengerPlane;
import Models.Plane.Plane;
import Models.Plane.PrivatePlane;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlaneDb {

    private List<Plane> planes;
    private List<Route> routes;
    private List<Ticket> tickets;
    private List<User> users;
    private List<Location> locations;

    private IFileService fileService;
    Gson json;

    public PlaneDb(IFileService fileService) {
        json = new GsonBuilder().setPrettyPrinting().create();
        this.fileService = fileService;
        planes = new ArrayList<>();
        routes = new ArrayList<>();
        tickets = new ArrayList<>();
        users = new ArrayList<>();
        insertValuesIntoLocation();
    }

    public PlaneDb(List<Plane> planes, List<Route> routes, List<Ticket> tickets, List<User> users, List<Location> locations, IFileService fileService) {
        json = new GsonBuilder().setPrettyPrinting().create();
        this.fileService = fileService;
        setPlanes(planes);
        setRoutes(routes);
        setTickets(tickets);
        setUsers(users);
        setLocations(locations);
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public List<Plane> getPlanes() {
        return planes;
    }

    public void setPlanes(List<Plane> planes) {
        this.planes = planes;
    }

    public List<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }


    public void insertValuesIntoLocation() {
        Location Dublin = new Location();
        Location Manchester = new Location();
        Location London = new Location();
        Location Brussels = new Location();
        Location Paris = new Location();
        Location Berlin = new Location();
        Location Prague = new Location();
        Location Vienna = new Location();
        Location Krakow = new Location();
        Location Sarajevo = new Location();
        Location Madrid = new Location();
        this.locations = new ArrayList<>() {{
            add(Dublin);
            add(Manchester);
            add(London);
            add(Brussels);
            add(Paris);
            add(Berlin);
            add(Prague);
            add(Vienna);
            add(Krakow);
            add(Sarajevo);
            add(Madrid);
        }};
    }

    public void writeLocationsInFile() {
        String locations = json.toJson(this.locations, new TypeToken<ArrayList<Location>>() {
        }.getType());
        fileService.writeInFile(locations, fileService.getLocationFile());
    }

    public void writeRoutesInFile() {
        String routes = json.toJson(this.routes, new TypeToken<ArrayList<Route>>() {
        }.getType());
        fileService.writeInFile(routes, fileService.getRouteFile());
    }

    public void writePlanesInFile() {
        String planes = json.toJson(this.planes, new TypeToken<ArrayList<Plane>>() {
        }.getType());
        fileService.writeInFile(planes, fileService.getPlaneFile());
    }

    public void writeUsersInFile() {
        String users = json.toJson(this.users, new TypeToken<ArrayList<User>>() {
        }.getType());
        fileService.writeInFile(users, fileService.getUserFile());
    }

    public void writeTicketsInFile() {
        String tickets = json.toJson(this.tickets, new TypeToken<ArrayList<Ticket>>() {
        }.getType());
        fileService.writeInFile(tickets, fileService.getUserFile());
    }

    public void readLocationsFromFile() {
        String resJson = fileService.readFromFile(fileService.getLocationFile());

        this.locations = Arrays.asList(json.fromJson(resJson, Location[].class));
    }

    public void readRoutesFromFile() {
        String resJson = fileService.readFromFile(fileService.getRouteFile());

        this.routes = Arrays.asList(json.fromJson(resJson, Route[].class));
    }

    public void readPlanesFromFile() {
        String resJson = fileService.readFromFile(fileService.getPlaneFile());

        this.planes = Arrays.asList(json.fromJson(resJson, Plane[].class));
    }

    public void readUsersFromFile() {
        String resJson = fileService.readFromFile(fileService.getUserFile());

        this.users = Arrays.asList(json.fromJson(resJson, User[].class));
    }

    public void readTicketsFromFile() {
        String resJson = fileService.readFromFile(fileService.getTicketFile());

        this.tickets = Arrays.asList(json.fromJson(resJson, Ticket[].class));
    }


    public void insertValuesIntoPlane() {
        Plane A220_100 = new PassengerPlane();
        Plane FordPlane = new PrivatePlane();
        Plane An_225Mrija = new CargoPlane(3, this.locations.get(8), 250, new ArrayList<Route>(), Height.height2, 250000.0, 1300.0);
        Plane Boeing_777F = new CargoPlane();
        Plane Airbus_A300_600F = new CargoPlane();
    }

}
