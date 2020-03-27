package source;
// Grid is an abstract class
// selfGrid and enemyGrid can extend the Grid
// 3 fields to desribe the status of Grid
// 1 abstract method required to make differnt implementation for each Grid


public abstract class Grid {
    // the number of ships in the grid
    public int shipNum;
    // the map would be seen by the player
    public Character[][] map;
    // the ships(objects) initialized and stored in this class
    public Ship[] shipList;

    // initializer, drawing the empty grid map
    // ensure the maximun ship number is 10
    // ensure the map is 20*10
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