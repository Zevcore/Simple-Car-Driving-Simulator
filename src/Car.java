import java.awt.*;
import java.awt.event.KeyEvent;
import java.security.Key;

public class Car {

    /* Obiekt samochód z jego danymi */

    private int speed = 0;
    private int gear = 0;

    private boolean gearUp = false;
    private boolean gearDown = false;

    private int rpm = 0;
    private boolean engine = false;
    private boolean lights = false;

    private Keyboard keyboard;
    private Screen s;

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

    public Car(Screen s) {
        this.s = s;
        keyboard = s.getK();
    }

    public void render(Graphics g) {

        //width 1280
        //height 800

        //1280 / 2 = 640 - 100

        // Predkosciomierz
        g.setColor(Color.GRAY);
        g.drawRect(540, 50, 100 * 2, 20);
        if(speed > 70) {
            g.setColor(Color.red);
        }
        else {
            g.setColor(Color.green);
        }
        g.fillRect(540, 50, speed * 2, 20);
        g.drawString("PREDKOSC: " + speed, 540, 100);

        g.setColor(Color.GRAY);
        g.drawString("OBROTY: " + rpm, 540, 120);

        // Biegi
        g.drawRect(540, 140, 20, 20); // wsteczny
        g.drawString("R", 545, 157);
        g.drawRect(570, 140, 20, 20); // neutral
        g.drawString("N", 575, 157);
        g.drawRect(600, 140, 20, 20); // 1
        g.drawString("1", 606, 157);
        g.drawRect(630, 140, 20, 20); // 2
        g.drawString("2", 636, 157);
        g.drawRect(660, 140, 20, 20); // 3
        g.drawString("3", 666, 157);
        g.drawRect(690, 140, 20, 20); // 4
        g.drawString("4", 696, 157);
        g.drawRect(720, 140, 20, 20); // 5
        g.drawString("5", 726, 157);

        g.setColor(Color.green);
        if(gear == -1) {
            g.fillRect(540, 140, 20, 20);
        }
        else if(gear == 0) {
            g.fillRect(570, 140, 20, 20);
        }
        else if(gear == 1) {
            g.fillRect(600, 140, 20, 20);
        }
        else if(gear == 2) {
            g.fillRect(630, 140, 20, 20);
        }
        else if(gear == 3) {
            g.fillRect(660, 140, 20, 20);
        }
        else if(gear == 4) {
            g.fillRect(690, 140, 20, 20);
        }
        else {
            g.fillRect(720, 140, 20, 20);
        }

        // Silnik
        g.setColor(Color.gray);
        g.drawRect(540, 170, 20, 20);
        if(engine) {
            g.setColor(Color.green);
            g.fillRect(540, 170, 20, 20);
        }
        else {
            g.setColor(Color.red);
            g.fillRect(540, 170, 20, 20);
        }
        g.setColor(Color.gray);
        g.drawString("SILNIK", 565, 187);

        // Swiatla
        g.drawRect(540, 200, 20, 20);
        if(lights) {
            g.setColor(Color.green);
            g.fillRect(540, 200, 20, 20);
            g.drawString("SWIATLA", 565, 217);
        }
        else {
            g.setColor(Color.red);
            g.fillRect(540, 200, 20, 20);
            g.drawString("WLACZ SWIATLA!", 565, 217);
        }

        // Instrukcja
        g.setColor(Color.gray);
        g.drawString("SILNIK - ENTER", 540, 500);
        g.drawString("SWIATLA - SHIFT", 540, 520);
        g.drawString("BIEG W GORE - Q", 540, 540);
        g.drawString("BIEG W DOL - E", 540, 560);
        g.drawString("GAZ - W", 540, 580);
        g.drawString("HAMULEC - S", 540, 600);

    }

    public void update() {
        /* Aktualizowanie danych na ekranie po nacisnięciu przycisku */
        checkKeys();

    }

    public void checkKeys() {
        // Silnik
        if(keyboard.typed(KeyEvent.VK_ENTER)) {
            if(engine) {
                engine = false;
            }
            else {
                this.rpm = 800;
                engine = true;
            }
        }

        // Swiatla
        if(keyboard.typed(KeyEvent.VK_SHIFT)) {
            if(lights) lights = false;
            else lights = true;
        }

        // Bieg w góre
        if(keyboard.typed(KeyEvent.VK_Q)) {
            changeGear(true);
        }

        // Bieg w dół
        if(keyboard.typed(KeyEvent.VK_E)) {
            changeGear(false);
        }

        // Jazda do przodu
        if(keyboard.typed(KeyEvent.VK_W)) {
            drive();
        }

        // Hamulec
        if(keyboard.typed(KeyEvent.VK_S)) {
            slow();
        }


    }

    public void changeGear(boolean upOrDown) {
        // Ograniczenie do 5 biegów
        // Wsteczny to - 1
        // Neutral to 0
        if(upOrDown) {
            if(gear != 5) {
                gear++;
            }
        }
        else {
            if(gear != -1) {
                gear--;
            }
        }
    }

    public void drive() {
        if(engine) {
            // Jazda do przodu
            if(gear > 0) {
                if(gear == 1) {
                    if(speed == 25) {
                        speed += 0;
                        // todo: wyswietl komunikat o zmianie biegu
                    }
                    else {
                        speed += 5;
                        rpm = speed * 125;
                    }
                }
                else if(gear == 2) {
                    if(speed == 45) {
                        speed += 0;
                        // todo: wyswietl komunikat o zmianie biegu
                    }
                    else {
                        speed += 5;
                        rpm = speed * 70;
                    }
                }
                else if(gear == 3) {
                    if(speed == 65) {
                        speed += 0;
                        // todo: wyswietl komunikat o zmianie biegu
                    }
                    else {
                        speed += 5;
                        rpm = speed * 50;
                    }
                }
                else if(gear == 4) {
                    if(speed == 85) {
                        speed += 0;
                        // todo: wyswietl komunikat o zmianie biegu
                    }
                    else {
                        speed += 5;
                        rpm = speed * 30;
                    }
                }
                else if(gear == 5) {
                    if(speed == 100) {
                        speed += 0;
                        // todo: max speed
                    }
                    else {
                        speed += 5;
                        rpm = speed * 20;
                    }
                }
            }
            else if(gear == -1) {
                if(speed == 15) {
                    speed += 0;
                }
                else {
                    speed += 5;
                    rpm += 300;
                }
            }
        }
    }

    public void slow() {
        if(!engine) {
            rpm = 0;
            speed-=5;
        }
        if(engine) {
            if(speed > 0) {
                speed -= 5;
                if(rpm > 800) {
                    rpm /= 5;
                    if(rpm < 800) {
                        rpm = 800;
                    }
                }
            }
        }
    }


}
