package pl.wsb.car;

import java.awt.*;

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

    public void render(Graphics g) {

        if(engine) {
            g.drawString("Silnik: włączony", 10, 20);
        }
        else {
            g.drawString("Silnik: wyłączony", 10, 20);
        }

        if(lights) {
            g.drawString("Swiatla: włączone", 10, 50);
        }
        else {
            g.drawString("Swiatla: wyłączone", 10, 50);
        }

        if(gear == -1) {
            g.drawString("Bieg: R", 10, 80);
        }
        else if(gear == 0) {
            g.drawString("Bieg: Neutral", 10, 80);
        }
        else {
            g.drawString("Bieg: " + gear, 10, 80);
        }

        g.drawString("Obroty silnika: " + rpm, 10, 110);

    }
}
