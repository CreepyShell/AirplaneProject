package Models;

import java.util.List;

public class Line {
    private double x;
    private double y;
    private double number;

    public Line(){
        setNumber(0);
        setX(0);
        setY(0);
    }
    public Line(double x, double y, double number) {
        setX(x);
        setY(y);
        setNumber(number);
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
