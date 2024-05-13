public class Computer {

    GamePanel gp;
    Algorithm alg;
    int[][] map;
    int rows, cols;
    int compSym;
    int playSym;
    public Computer(GamePanel gp, Algorithm alg){
        this.gp=gp;
        this. alg = alg;
        this.map = gp.map;
    }

    void setPlayers(int compSym, int playSym){
        this. compSym=compSym;
        this. playSym=playSym;

        System.out.println(compSym +" "+ playSym);
    }

    void computerMoves(){


        int i,j;
        int counter;
        int counterFree;
        int saveI=0, saveJ=0;

        for(i=0;i<gp.screenColNum;i++) {
            counter=0;
            counterFree=0;
            for (j = 0; j < gp.screenColNum; j++){
                if (map[i][j]==compSym)
                    counter++;
                else if(map[i][j]==2)
                {
                    counterFree++;
                    saveI=i;
                    saveJ=j;
                }
            }
            if(counter==2 && counterFree==1)
            {
                rows=saveI;
                cols=saveJ;
                return;
            }

        }

        for(i=0;i<gp.screenColNum;i++) {
            counter=0;
            counterFree=0;
            for (j = 0; j < gp.screenColNum; j++){
                if (map[j][i]==compSym)
                    counter++;
                else if(map[j][i]==2)
                {
                    counterFree++;
                    saveI=i;
                    saveJ=j;
                }
            }
            if(counter==2 && counterFree==1)
            {
                rows=saveJ;
                cols=saveI;
                return;
            }

        }

        counter=0;
        counterFree=0;
        for(i=0;i<gp.screenColNum;i++){
            if(map[i][i]==compSym)
                counter++;
            else if(map[i][i]==2) {
                counterFree++;
                saveI=i;
            }
        }
        if(counter==2 && counterFree==1){
            rows=saveI;
            cols=saveI;
            return;
        }

        counter=0;
        counterFree=0;
        for(i=0;i<gp.screenColNum;i++){
            if(map[i][gp.screenColNum-1-i]==compSym)
                counter++;
            else if(map[i][gp.screenColNum-1-i]==2) {
                counterFree++;
                saveI=i;
            }
        }
        if(counter==2 && counterFree==1){
            rows=saveI;
            cols=gp.screenColNum-1-saveI;
            return;
        }

        //////////////////////////////////

        for(i=0;i<gp.screenColNum;i++) {
            counter=0;
            counterFree=0;
            for (j = 0; j < gp.screenColNum; j++){
                if (map[i][j]==playSym)
                    counter++;
                else if(map[i][j]==2)
                {
                    counterFree++;
                    saveI=i;
                    saveJ=j;
                }
            }
            if(counter==2 && counterFree==1)
            {
                rows =saveI;
                cols = saveJ;
                return;
            }

        }

        for(i=0;i<gp.screenColNum;i++) {
            counter=0;
            counterFree=0;
            for (j = 0; j < gp.screenColNum; j++){
                if (map[j][i]==playSym)
                    counter++;
                else if(map[j][i]==2)
                {
                    counterFree++;
                    saveI=i;
                    saveJ=j;
                }
            }
            if(counter==2 && counterFree==1)
            {
                rows=saveJ;
                cols=saveI;
                return;
            }

        }

        counter=0;
        counterFree=0;
        for(i=0;i<gp.screenColNum;i++){
            if(map[i][i]==playSym)
                counter++;
            else if(map[i][i]==2) {
                counterFree++;
                saveI=i;
            }
        }
        if(counter==2 && counterFree==1){
            rows = saveI;
            cols = saveI;
            return;
        }

        counter=0;
        counterFree=0;
        for(i=0;i<gp.screenColNum;i++){
            if(map[i][gp.screenColNum-1-i]==playSym)
                counter++;
            else if(map[i][gp.screenColNum-1-i]==2) {
                counterFree++;
                saveI=i;
            }
        }

        if(counter==2 && counterFree==1){
            rows = saveI;
            cols = gp.screenColNum-1-saveI;
            return;
        }

        if(map[1][1]==2){
            rows=1;
            cols=1;
            return;
        }

        for(i=0;i<gp.screenColNum;i++)
            for(j=0;j<gp.screenColNum;j++)
                if(map[i][j]==2) {
                    rows=i;
                    cols=j;
                    return;
                }


    }

    void setGrid(int[][] map){
        this.map=map;
    }


}
