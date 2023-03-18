package org.example;

public class Ride {
    public final double distance;
    public final int time;
    public enum RideType {
         NORMAL, PREMIUM, RIDES;
    }

    public Ride (double distance, int time) {

        this.distance = distance;
        this.time = time;

    }
}
