import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Objects;

public class MouseHandler implements MouseListener {

    GamePanel gp;
    GridHandler gridHandler;
    public MouseHandler(GamePanel gp, GridHandler gridHandler){
        this.gp = gp;
        this.gridHandler = gridHandler;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(gridHandler.alg.status && e.getX()<gp.screenLength && e.getY()<gp.screenLength) {
            if(gp.buttonsPanel.playModepressed && gp.buttonsPanel.symbolChoicepressed) {
                int mouseX = e.getX();
                int mouseY = e.getY();
                int gridX = -1;
                int gridY = -1;
                int i;

                for (i = 0; i < gp.screenLength; i += gp.boxSize, gridX++) {
                    if (i > mouseX)
                        break;
                }

                for (i = 0; i < gp.screenLength; i += gp.boxSize, gridY++) {
                    if (i > mouseY)
                        break;
                }

                System.out.println(gridY); //asta merge pe linii
                System.out.println(gridX); //asta merge pe coloane
                if(gridHandler.map[gridY][gridX]==2) {

                    gridHandler.setCoordinates(gridY, gridX);
                    gridHandler.setMap();
                    gp.setGrid(gridHandler.map);
                    gridHandler.alg.setGrid(gridHandler.map);
                    gridHandler.alg.checkWin();
                    gridHandler.alg.switchPlayer();
                    gridHandler.alg.moveTracker();
                    gp.repaint();

                    if (Objects.equals(gp.buttonsPanel.playMode, "computer") && gridHandler.alg.status) {
                        gp.computer.setGrid(gridHandler.map);
                        gp.computer.computerMoves();
                        gridHandler.setCoordinates(gp.computer.rows, gp.computer.cols);
                        gridHandler.setMap();
                        gp.setGrid(gridHandler.map);
                        gridHandler.alg.setGrid(gridHandler.map);
                        gridHandler.alg.checkWin();
                        gridHandler.alg.switchPlayer();
                        gridHandler.alg.moveTracker();
                        gp.repaint();
                    }
                }
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
