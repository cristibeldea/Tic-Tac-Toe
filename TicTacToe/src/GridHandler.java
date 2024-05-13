public class GridHandler {

    GamePanel gp;
    Algorithm alg;
    Computer computer;
    int[][] map;
    int rows;
    int cols;
    public GridHandler(GamePanel gp, Algorithm alg, Computer computer){
        this.gp = gp;
        this.alg = alg;
        this.computer = computer;
    }
    public void createGrid(){
        int i,j;
        this.map = new int[gp.screenColNum+1][gp.screenColNum+1];

        for(i=0;i<gp.screenColNum;i++)
            for(j=0;j<gp.screenColNum;j++)
                map[i][j] = 2;
    }

    public void setCoordinates(int rows, int cols){
        if(map[rows][cols]==2) {
            this.rows=rows;
            this.cols=cols;
        }

    }

    public void setMap(){
        if(map[rows][cols]==2) {
            map[rows][cols]=alg.getSymbol();
        }
    }

}
