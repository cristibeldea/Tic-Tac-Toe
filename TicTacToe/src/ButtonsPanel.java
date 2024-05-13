import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonsPanel extends JPanel {
    int modeButtonWidth=80;
    int modeButtonHeight=50;
    int symbolButtonWidth=50;
    int symbolButtonHeight=50;
    int panelWidth= 300;
    int panelHeight=200;
    boolean playModepressed = false;
    boolean symbolChoicepressed = false;
    String playMode;
    char symbolChoice;
    JButton computer, player;
    JButton x,o;
    JButton reset;

    public ButtonsPanel() {
        this.setPreferredSize(new Dimension(panelWidth, panelHeight));
        this.setVisible(true);
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.setLayout(null);

        computer = new JButton();
        computer.setBounds((panelWidth-modeButtonWidth)/5, (panelHeight-modeButtonHeight)/5, modeButtonWidth, modeButtonHeight);
        computer.setBackground(Color.black);
        computer.setFocusable(false);
        computer.setForeground(Color.white);
        computer.setText("VS PC");
        computer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!playModepressed) {
                    playModepressed = true;
                    playMode = "computer";
                    computer.setBounds((panelWidth - modeButtonWidth) / 2, (panelHeight - modeButtonHeight) / 5, modeButtonWidth, modeButtonHeight);
                    hideButton(player);
                    Container.gPanel.alg.setupPlayer();
                }
            }
        });
        this.add(computer);

        player = new JButton();
        player.setBounds((panelWidth-modeButtonWidth)*4/5, (panelHeight-modeButtonHeight)/5, modeButtonWidth, modeButtonHeight);
        player.setBackground(Color.black);
        player.setFocusable(false);
        player.setForeground(Color.white);
        player.setText("1 VS 1");
        player.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!playModepressed) {
                    playModepressed = true;
                    playMode = "player";
                    player.setBounds((panelWidth - modeButtonWidth) / 2, (panelHeight - modeButtonHeight) / 5, modeButtonWidth, modeButtonHeight);
                    hideButton(computer);
                    Container.gPanel.alg.setupPlayer();
                }
            }
        });
        this.add(player);

        x = new JButton();
        x.setBounds((panelWidth-symbolButtonWidth)/5, (panelHeight-symbolButtonHeight)*3/5, symbolButtonWidth, symbolButtonHeight);
        x.setBackground(Color.black);
        x.setFocusable(false);
        x.setForeground(Color.white);
        x.setText("X");
        x.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!symbolChoicepressed) {
                    symbolChoicepressed = true;
                    symbolChoice = 'x';
                    x.setBounds((panelWidth - symbolButtonWidth) / 2, (panelHeight - symbolButtonHeight) * 3 / 5, symbolButtonWidth, symbolButtonHeight);
                    hideButton(o);
                    Container.gPanel.alg.setupPlayer();
                }
            }
        });
        this.add(x);

        o = new JButton();
        o.setBounds((panelWidth-symbolButtonWidth)*4/5, (panelHeight-symbolButtonHeight)*3/5, symbolButtonWidth, symbolButtonHeight);
        o.setBackground(Color.black);
        o.setFocusable(false);
        o.setForeground(Color.white);
        o.setText("O");
        o.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!symbolChoicepressed) {
                    symbolChoicepressed = true;
                    symbolChoice = 'o';
                    o.setBounds((panelWidth - symbolButtonWidth) / 2, (panelHeight - symbolButtonHeight) * 3 / 5, symbolButtonWidth, symbolButtonHeight);
                    hideButton(x);
                    Container.gPanel.alg.setupPlayer();
                }
            }
        });
        this.add(o);

        reset = new JButton();
        reset.setBounds((panelWidth-modeButtonWidth)/2, panelHeight-modeButtonHeight, modeButtonWidth, modeButtonHeight);
        reset.setBackground(Color.black);
        reset.setFocusable(false);
        reset.setForeground(Color.white);
        reset.setText("RESET");
        reset.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Container.window.dispose();
                new Container();
            }
        });
        this.add(reset);



    }

    void hideButton(JButton button){
        button.setVisible(false);
    }

}
