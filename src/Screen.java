import java.awt.*;

public class Screen extends Canvas {

    private int width;
    private int height;

    private Keyboard k;

    public Screen(int width, int height) {

        this.width = width;
        this.height = height;

        setPreferredSize(new Dimension(width, height));
        setMaximumSize(new Dimension(width, height));
        setMinimumSize(new Dimension(width, height));
        k = new Keyboard();
        addKeyListener(k);
    }

    public Keyboard getK() {
        return k;
    }
}
