package Models;

public class Location {
    private String id;
    private double x;
    private double y;
    private String city;
    private String country;

    public Location(String id, double x, double y, String city, String country) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.city = city;
        this.country = country;
    }

    public Location() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
