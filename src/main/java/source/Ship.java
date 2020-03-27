package source;

// Ship is an abstract class and 4 different kind of ships can extend this protocol
// 7 fields to desribe the status of ship
// 2 abstract methods required to make differnt implementation for each ship
// 2 methods in the firing action: hasBlock, updateFire
// 1 method to determine if the ship fall to determine the result of the game

abstract class Ship{
    // the shortcut name
    public Character name;
    // like [3,1] the left corner
    public int[] pivot;
    // the whole name (not yet used )
    public String type;
    // h or z in version 1; cover the left and right in the version 2
    public char direction;
    // the local tiny map, recording the path
    public Character[][] shipMap;
    // whole blocks the ship would take in the ocean, for example: submarine takes 2
    public int blocks;
    // record the change based on pivot, for example, the original plce is [0][0], the right is [0][1]
    public int[][] route;


    // abstract method which can be implemented in each kind of ship's class
    // the initialization part depends on the attributes for the type of the ship
    abstract void initRoute(char direction);
    abstract void initMap();


    // see if the ship covered the block in the ocean
    boolean hasBlock(int row, int column){
        //System.out.println("the row and column is " + row + ", " + column);
        //System.out.println(this.blocks + "blocks");
        for (int i = 0; i < this.blocks; ++i) {
            //System.out.println("the route is "+ route[i][0] + ", " + route[i][1]);
            //System.out.println("the pivot is "+ pivot[0] + ", " + pivot[1]);
            if (this.route[i][0] + this.pivot[0] == row){
                if (this.route[i][1] + this.pivot[1] == column){
                    return true;
                }
            }
        }
        return false;
    }


    // update the tiny map by the fire signal from selfGrid
    void updateFire(int row, int column){
        this.shipMap[row - pivot[0]][column - pivot[1]] = new Character('*');
    }


    // determine if all of the blocks in the path are guessed out by other player
    boolean isFall(){
        for (int i = 0; i < this.blocks; ++i) {
            if (!this.shipMap[this.route[i][0]][this.route[i][1]].equals('*')){
                return false;
            }
        }
        return true;
    }
}