import pl.wsb.Simulator;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

    public Window(Simulator s) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new FlowLayout());

        add(s);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

}
