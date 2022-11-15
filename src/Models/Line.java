package Models;

import java.util.UUID;

public class Line {
    private String id;
    private double x;
    private double y;
    private double number;

    public Line(){
        setId();
        setNumber(0);
        setX(0);
        setY(0);
    }
    public Line(double x, double y, double number) {
        setId();
        setX(x);
        setY(y);
        setNumber(number);
    }
    public String getId(){
        return this.id;
    }
    private void setId(){
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

    public double getNumber() {
        return number;
    }

    public void setNumber(double number) {
        this.number = number;
    }
}
