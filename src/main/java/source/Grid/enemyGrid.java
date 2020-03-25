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

    public Character findBlock(int row, int column){
        return unHidMap[row][column];
    }

    public void fireAt(int row, int column, Character sign){
        // change the hidden map
        this.map[row][column] = sign;
        // change the real enemy's map, update later
        if (sign.equals('s') || sign.equals('d') || sign.equals('b') || sign.equals('c')){
            this.unHidMap[row][column] = new Character('*');
        }
    }

}