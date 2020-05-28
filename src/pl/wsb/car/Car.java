package pl.wsb.car;

public class Car {

    private int speed = 0;
    private int gear = 0;
    private int rpm = 0;
    private boolean engine = false;
    private boolean lights = false;
    private boolean music = false;

    /*

        Biegi:
        -1 - wsteczny
         0 - neutral
         1
         2
         3
         4
         5

     */

    public Car() {

    }

    public int getSpeed() {
        return speed;
    }

    public int getGear() {
        return gear;
    }

    public int getRpm() {
        return rpm;
    }

    public boolean isEngine() {
        return engine;
    }

    public boolean isLights() {
        return lights;
    }

    public boolean isMusic() {
        return music;
    }
}
