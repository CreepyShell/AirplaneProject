package Models;

import java.util.UUID;

public class Location {
    private String id;
    private double x;
    private double y;
    private String city;
    private String country;

    public Location(double x, double y, String city, String country) {
       setId();
       setX(x);
       setY(y);
       setCity(city);
       setCountry(country);
    }

    public Location() {
        setId();
        setY(0);
        setX(0);
        setCity("null");
        setCountry("null");
    }

    public String getId() {
        return id;
    }

    private void setId() {
        this.id = UUID.randomUUID().toString();
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
