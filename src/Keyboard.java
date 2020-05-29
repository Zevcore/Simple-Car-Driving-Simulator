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
        updateKeys(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        pressing = false;
    }

    public void updateKeys(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_E){
            if(keyEngine == true) keyEngine = false;
            else keyEngine = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_L){
            if(keyLights == true) keyLights = false;
            else keyLights = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_M){
            if(keyMusic == true) keyMusic = false;
            else keyMusic = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_W){
            if(speedUp == true) speedUp = false;
            else speedUp = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_S){
            if(speedDown == true) speedDown = false;
            else speedDown = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_UP){
            if(gearUp == true) gearUp = false;
            else gearUp = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN){
            if(gearDown == true) gearDown = false;
            else gearDown = true;
        }
    }

}
