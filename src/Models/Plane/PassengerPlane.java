package Models.Plane;

import java.security.InvalidParameterException;

public class PassengerPlane extends Plane {


    @Override
    public void setMaxAmountOfSeats(int maxAmountOfSeats) {
        if (maxAmountOfSeats > 440 || maxAmountOfSeats < 0)
            throw new InvalidParameterException("Too many amount of seats in passenger plane or its value less than zero");
        this.maxAmountOfSeats = maxAmountOfSeats;
    }

    @Override
    public void setSpeed(double speed) {
        if (speed > 255 || speed < 0)
            throw new InvalidParameterException("Passenger plane too fast or its speed less than zero");
        this.speed = speed;
    }

    @Override
    public void setMaxFlyDistance(double maxFlyDistance) {
        if (maxFlyDistance > 18000000 || maxFlyDistance < 100000)
            throw new InvalidParameterException("Max fly distance of a passenger plane is too long or too short(can be between 100km and 18 000km)");
        this.maxFlyDistance = maxFlyDistance;
    }
}
