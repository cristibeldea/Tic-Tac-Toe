import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class GamePanel extends JPanel {
    final int boxSize = 100;
    final int screenColNum = 3;
    final int screenLength = boxSize * screenColNum;
    int[][]map;
    int symbol;
    Algorithm alg;
    WinningLine line;
    ButtonsPanel buttonsPanel;
    Computer computer;
    public GamePanel(ButtonsPanel buttonsPanel){
        this.setPreferredSize(new Dimension(screenLength+1, screenLength+1));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);

        line = new WinningLine(this);
        alg = new Algorithm(this,line);

        this.buttonsPanel=buttonsPanel;
        computer = new Computer(this, alg);

        GridHandler gridHandler = new GridHandler(this, alg, computer);
        MouseHandler mouseH = new MouseHandler(this, gridHandler);
        this.addMouseListener(mouseH);
        gridHandler.createGrid();
    }

    void setGrid(int[][] map){
        this.map = map;
    }

    void setSymbol(int symbol){
        this.symbol = symbol;
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        int i,j;


        g2.setColor(Color.white);
        for (i = 0; i < screenColNum; i++)
            for (j = 0; j < screenColNum; j++)
                g2.drawRect(i * boxSize, j * boxSize, boxSize, boxSize);

        if(map!=null){
            for (i = 0; i < screenColNum; i++)
                for (j = 0; j < screenColNum; j++)
                {
                        if (map[i][j] == 0) {
                            g2.drawOval(j*boxSize + boxSize / 10, i*boxSize + boxSize / 10, boxSize - 2*boxSize / 10, boxSize - 2*boxSize / 10);
                        } else if (map[i][j] == 1) {
                            g2.drawLine(j * boxSize + boxSize / 10, i * boxSize + boxSize / 10, j*boxSize + boxSize- boxSize / 10, i*boxSize + boxSize- boxSize / 10);
                            g2.drawLine(j * boxSize + boxSize / 10, i*boxSize + boxSize - boxSize / 10, j*boxSize +boxSize - boxSize / 10, i*boxSize + boxSize / 10);
                        }
                }
        }

        if(!alg.status){
            g2.setColor(Color.red);
            g2.setStroke(new BasicStroke(4));

            if(Objects.equals(line.lineType, "diag1"))
                g2.drawLine(0,0,screenColNum*boxSize ,screenColNum*boxSize);

            if(Objects.equals(line.lineType, "diag2"))
                g2.drawLine(0, screenColNum*boxSize , screenColNum*boxSize,0);

            if(Objects.equals(line.lineType, "row"))
                g2.drawLine(0,line.lineNum * boxSize + boxSize/2, screenColNum*boxSize, line.lineNum * boxSize + boxSize/2 );

            if(Objects.equals(line.lineType, "col"))
                g2.drawLine(line.lineNum * boxSize + boxSize/2, 0, line.lineNum * boxSize + boxSize/2, screenColNum*boxSize);
        }
    }
}