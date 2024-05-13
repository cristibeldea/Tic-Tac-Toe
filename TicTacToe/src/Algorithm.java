import org.w3c.dom.css.Rect;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class Algorithm {

    int[][] map;
    int Player1;
    int Player2;
    int moves=0;
    GridHandler gridHandler;
    int Player;
    int Adversary;
    GamePanel gp;
    WinningLine line;
    int textWidth=150;
    int textHeight=80;
    int paddingLeft=20;

    boolean status =true;

    public Algorithm(GamePanel gp, WinningLine line){
        this.gp = gp;
        this.line = line;
    }
    void setGrid(int[][] map) {
        this.map = map;
    }


    void setupPlayer(){
        char inputSymbol;

        inputSymbol=gp.buttonsPanel.symbolChoice;

        if(inputSymbol=='x'){
            Player1 = 1;
            Player2 = 0;
        }
        else if(inputSymbol=='o'){
            Player1 = 0;
            Player2 = 1;
        }

        gp.computer.setPlayers(Player2, Player1);
    }


    void switchPlayer(){
        if(this.moves%2==1){
            Player=Player1;
            Adversary=Player2;
            gp.setSymbol(Player1);
        }
        else if(this.moves%2==0){
            Player=Player2;
            Adversary=Player1;
            gp.setSymbol(Player2);
        }
    }

    void moveTracker(){
        if(moves!=9) {
            moves++;
        }
        if(moves==9 && status) {
            System.out.println("EVEN");
            JLabel label = new JLabel("EVEN");
            label.setForeground(Color.green);
            label.setSize(120,60);
            label.setVisible(true);
            label.setFont(new Font("Arial", Font.BOLD, 40));
            label.setBounds((gp.screenLength-textWidth)/2+paddingLeft, (gp.screenLength-textHeight)/2, textWidth, textHeight);
            gp.add(label);
        }
    }

    int getSymbol(){
        if(moves!=0)
            return Player;
        else if(moves==0)
            return Player1;
        return 10;
    }


    void checkWin(){
        int i,j;
        int counter;

        if(this.moves!=9){

                for(i=0;i<gp.screenColNum;i++) {
                    counter=0;
                    for (j = 0; j < gp.screenColNum; j++) {
                        if (map[i][j]==Player){
                            counter++;
                        }
                    }
                    if(counter==3) {
                        System.out.println(Player + " CASTIGA!");
                        status=false;
                        this.line.lineNum=i;
                        this.line.lineType="row";
                        return;
                    }
                }

                for(i=0;i<gp.screenColNum;i++) {
                    counter = 0;
                    for (j = 0; j < gp.screenColNum; j++) {
                        if (map[j][i] == Player) {
                            counter++;
                        }
                    }
                    if (counter == 3){
                        System.out.println(Player + " CASTIGA!");
                        status = false;
                        this.line.lineNum =i;
                        this.line.lineType="col";
                        return;
                    }
                }

                 counter = 0;
                for(i=0;i<gp.screenColNum;i++) {

                    if(map[i][i]==Player) {
                        counter++;
                    }
                }
                if(counter==3) {
                    System.out.println(Player + " CASTIGA!");
                    status = false;
                    this.line.lineType="diag1";
                    return;
                }

                counter=0;
                for(i=0;i<gp.screenColNum;i++){

                    if(map[i][gp.screenColNum-1-i]==Player){
                        counter++;
                    }
                }
                if(counter==3) {
                    System.out.println(Player + " CASTIGA!");
                    status = false;
                    this.line.lineType="diag2";
                    return;
                }

            ////////////////////

            for(i=0;i<gp.screenColNum;i++) {
                counter=0;
                for (j = 0; j < gp.screenColNum; j++) {
                    if (map[i][j]==Adversary){
                        counter++;
                    }
                }
                if(counter==3) {
                    System.out.println(Adversary + " CASTIGA!");
                    status = false;
                    this.line.lineNum=i;
                    this.line.lineType="row";
                    return;
                }
            }

            for(i=0;i<gp.screenColNum;i++) {
                counter = 0;
                for (j = 0; j < gp.screenColNum; j++) {
                    if (map[j][i] == Adversary) {
                        counter++;
                    }
                }
                if (counter == 3) {
                    System.out.println(Adversary + " CASTIGA!");
                    this.line.lineNum=i;
                    this.line.lineType="col";
                    status = false;
                    return;
                }
            }

            counter = 0;
            for(i=0;i<gp.screenColNum;i++) {

                if(map[i][i]==Adversary) {
                    counter++;
                }
            }
            if(counter==3) {
                System.out.println(Adversary + " CASTIGA!");
                status = false;
                this.line.lineType="diag1";
                return;
            }

            counter=0;
            for(i=0;i<gp.screenColNum;i++){

                if(map[i][gp.screenColNum-1-i]==Adversary){
                    counter++;
                }
            }
            if(counter==3) {
                System.out.println(Adversary + " CASTIGA!");
                status = false;
                this.line.lineType="diag2";
                return;
            }

           // moves++;
        }
    }
}
