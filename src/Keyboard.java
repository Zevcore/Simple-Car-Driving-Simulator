import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {

    public boolean[] pressed = new boolean[256];
    public boolean[] prev = new boolean[256];

    public Keyboard() {

    }

    public void update() {
        for(int i = 0; i < 7; i++) {
            if(i == 0) prev[KeyEvent.VK_ENTER] = pressed[KeyEvent.VK_ENTER];
            if(i == 1) prev[KeyEvent.VK_SHIFT] = pressed[KeyEvent.VK_SHIFT];
            if(i == 2) prev[KeyEvent.VK_M] = pressed[KeyEvent.VK_M];
            if(i == 3) prev[KeyEvent.VK_W] = pressed[KeyEvent.VK_W];
            if(i == 4) prev[KeyEvent.VK_S] = pressed[KeyEvent.VK_S];
            if(i == 5) prev[KeyEvent.VK_Q] = pressed[KeyEvent.VK_Q];
            if(i == 6) prev[KeyEvent.VK_E] = pressed[KeyEvent.VK_E];
        }
    }

    // silnik
    // światla
    // radio
    // do przodu
    // hamowanie
    // bieg gora
    // bieg dol

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        pressed[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        pressed[e.getKeyCode()] = false;
    }

    public boolean typed(int keyEvent) {
        return !pressed[keyEvent] && prev[keyEvent];
    }

}
