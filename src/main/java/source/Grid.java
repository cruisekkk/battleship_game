package source;

public abstract class Grid {
    public int shipNum;
    public Character[][] map;
    public Ship[] shipList;
    Grid(){
        this.shipNum = 0;
        this.shipList = new Ship[10];
        // map initialization
        this.map = new Character[20][10];
        for (int i = 0; i < 20; i++){
            for (int j = 0; j < 10; j++){
                map[i][j] = ' ';
            }
        }
    }

    public abstract String show();

}