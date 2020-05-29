import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class Container extends JFrame implements Runnable {

    /* Ustawienia okna */
    private final String title = "Sim";
    private final int width = 1280;
    private final int height = 720; // hd res

    /* Zawartość okna */
    private Screen screen;

    /* Ustawienia Runnable */
    private boolean running;
    private Thread thread;
    private int frames;
    private int updates;

    /* Grafiki */
    private BufferStrategy bs;
    private Graphics g;

    /* Samochód */
    private Car car;

    /* Wyłapywanie klawiatury */

    public Container() {

        /* Utworzenie okna */
        setTitle(title);
        setPreferredSize(new Dimension(width, height)); // -------- //
        setMinimumSize(new Dimension(width, height));   // Rozmiary //
        setMaximumSize(new Dimension(width, height));   // -------- //

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.WHITE);
        setLocationRelativeTo(null);
        setResizable(false);

        /* Dodanie zawartości do okna */
        screen = new Screen(width, height);
        add(screen);

        /* Wyświetlenie okna */
        pack();
        setVisible(true);


    }

    public synchronized void start() {
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop() {
        running = false;

        System.exit(0);
    }

    public void init() {
        car = new Car(screen);
    }

    public void update() {
        car.update();
    }

    public void render() {
        bs = screen.getBufferStrategy();
        if(bs == null) {
            screen.createBufferStrategy(3);
            return;
        }

        g = bs.getDrawGraphics();

        /* Wyświetlanie */
        g.fillRect(0, 0, width, height);
        g.setColor(Color.white);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 24));

        if(this.frames != 0) {
            g.drawString("FPS: " + this.frames, 1150, 20);
        }
        g.drawString("TICKS: " + updates, 1150, 50);
        car.render(g);


        bs.show();
        g.dispose();
    }

    @Override
    public void run() {
        long x = System.nanoTime();
        long y = System.currentTimeMillis();

        double ns = 1000000000D / 60D;
        double delta = 0; // Unprocessed

        int updates = 0;
        int frames = 0;

        init();

        while(running) {
            long now = System.nanoTime();
            delta += (now - x) / ns;
            x = now;

            boolean shouldRender = true;
            while(delta >= 1) {
                updates++;
                update();
                delta -= 1;
                shouldRender = true;
            }

            try {
                Thread.sleep(1);
            } catch(Exception e) {
                e.printStackTrace();
            }

            if(shouldRender) {
                frames++;
                render();

            }

            if(System.currentTimeMillis() - y >= 1000) {
                y += 1000;
                this.frames = frames;
                this.updates = updates;


                frames = 0;
                updates = 0;
            }
        }
    }

    public static void main(String[] args) {
        new Container().start();
    }

}
