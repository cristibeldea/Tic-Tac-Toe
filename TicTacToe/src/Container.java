import javax.swing.*;
import java.awt.*;

public class Container {

    ButtonsPanel bPanel;
    static JFrame window;
    static GamePanel gPanel;
    public Container() {
        window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("X&O");
        window.setLayout(new BorderLayout());

        bPanel = new ButtonsPanel();
        window.add(bPanel, BorderLayout.SOUTH);

        gPanel = new GamePanel(bPanel);
        window.add(gPanel, BorderLayout.NORTH);

        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}
