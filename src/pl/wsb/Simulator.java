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

    private int frames = 0;
    private int updates = 0;

    //Runnable settings
    private Thread thread;
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
        thread = new Thread(this, "sim");
        thread.start();
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

        System.out.println(this.frames);
    }
    public void update() {}

    @Override
    public void run() {
        long x = System.nanoTime();
        long y = System.currentTimeMillis();
        double ns = 1000000000.0 / 60.0;
        double delta = 0;
        int ticks = 0;
        int frames = 0;

        init();

        while(running) {
            long now = System.nanoTime();
            delta += (now - x) / ns;
            x = now;

            boolean renderThis = true;
            while (delta >= 1) {
                ticks++;
                update();
                delta -= 1;
                renderThis = true;
            }

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if(renderThis) {
                frames++;
                render();
            }

            if(System.currentTimeMillis() - y >= 1000) {
                y += 1000;
                this.frames = frames;
                this.updates = ticks;
                frames = 0;
                ticks = 0;
            }
        }
    }
}
