package source;

// a sub class of Grid
// maintain the map data during the ship fighting
// the player can get the fast reaction after their action because they have the enemy's map!
public class enemyGrid extends Grid{
    // the real map situation, as the same as enemy's selfGrid
    public Character[][] unHidMap;

    // initialize the enemyGrid by the selfGrid provided by the enemy in the GamePhase(main control loop)
    enemyGrid(selfGrid grid){
        this.shipNum = grid.shipNum;

        this.unHidMap = new Character[20][10];
        for (int i = 0; i < 20; i++){
            for (int j = 0; j < 10; j++){
                this.unHidMap[i][j] = grid.map[i][j];
            }
        }
        // also should initialize an empty for the displaying as enemy's grid when guessing
        // the player can only see this hidden map
        this.map = new Character[20][10];
        for (int i = 0; i < 20; i++){
            for (int j = 0; j < 10; j++){
                map[i][j] = ' ';
            }
        }
    }

    @Override
    // just for debug
    public String show(){
        return "s";
    }

    // find the what is the character in the enemy's real map
    public Character findBlock(int row, int column){
        return unHidMap[row][column];
    }

    // update the map and unHidMap after the player fire
    public void fireAt(int row, int column, Character sign){
        // change the hidden map
        this.map[row][column] = sign;
        // change the real enemy's map, update later
        if (sign.equals('s') || sign.equals('d') || sign.equals('b') || sign.equals('c')){
            this.unHidMap[row][column] = new Character('*');
        }
    }

}