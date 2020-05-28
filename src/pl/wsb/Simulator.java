package pl.wsb;

import com.sun.jdi.JDIPermission;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Simulator extends JPanel implements Runnable {

    //JPanel settings
    private int width = 1280;
    private int height = 720;

    //Runnable settings
    private Thread t;
    private boolean running;

    private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    private BufferStrategy bs;

    /*

        -1 - wsteczny
        0 - neutral
        1, 2, 3, 4, 5 - biegi

     */

    public Simulator() {
        setFocusable(true);
        setPreferredSize(new Dimension(width, height));
        setMaximumSize(new Dimension(width, height));
        setMinimumSize(new Dimension(width, height));

    }

    public void init() {
    }

    public synchronized void start() {
        if(running) return;
        running = true;
        t = new Thread(this, "sim");
        t.start();
    }

    public synchronized void stop() {
        if(!running) return;
        running = false;

        System.exit(0);
    }

    public void render() {
        Graphics2D g = (Graphics2D) image.getGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(10, 10, 100, 100);
        g.dispose();
    }
    public void update() {}

    public void run() {
        int fps = 0; // frames per sec
        int updates = 0; // updates per sec

        double ns = 1000000000D / 60D;
        double then = System.nanoTime();
        double unprocessed = 0;

        long fpsTimer = System.currentTimeMillis();

        while(running) {
            boolean render = false;
            double now = System.nanoTime();

            unprocessed += (now - then) / ns;

            while(unprocessed >= 1) {
                updates++;
                update();
                unprocessed--;
                render = true;
            }

            if(render) {
                fps++;
                render();
                render = false;
            } else {
                try {
                    t.sleep(1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        if(System.currentTimeMillis() - fpsTimer > 1000) {
            System.out.printf("%d FPS", fps);
            System.out.println();

            fps = 0;
            updates = 0;
            fpsTimer += 1000;
        }

    }
}
