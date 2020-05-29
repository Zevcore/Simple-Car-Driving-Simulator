import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {

    public Keyboard() {}

    /* Przyciski */
    public boolean keyEngine;
    public boolean keyLights;
    public boolean keyMusic;
    public boolean speedUp;
    public boolean speedDown;
    public boolean gearUp;
    public boolean gearDown;

    /* */
    public boolean pressing;


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        pressing = true;
        if(e.getKeyCode() == KeyEvent.VK_E){
            if(keyEngine == true) keyEngine = false;
            else keyEngine = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_L){
            if(keyLights == true) keyLights = false;
            else keyLights = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        pressing = false;
    }

}
