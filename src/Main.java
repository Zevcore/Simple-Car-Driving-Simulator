import pl.wsb.Simulator;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static String title = "Simulator";

    public static void main(String[] args) {
        Simulator s = new Simulator();
        Window w = new Window(s);
        w.setTitle(title);
        s.start();

    }

}
