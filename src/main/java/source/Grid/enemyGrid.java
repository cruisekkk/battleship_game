package source;

public class enemyGrid extends Grid{
    public Character[][] unHidMap;

    enemyGrid(selfGrid grid){
        this.shipNum = grid.shipNum;

        this.unHidMap = new Character[20][10];
        for (int i = 0; i < 20; i++){
            for (int j = 0; j < 10; j++){
                this.unHidMap[i][j] = grid.map[i][j];
            }
        }

        this.map = new Character[20][10];
        for (int i = 0; i < 20; i++){
            for (int j = 0; j < 10; j++){
                map[i][j] = ' ';
            }
        }
    }


    @Override
    public String show(){
        return "s";
    }

}