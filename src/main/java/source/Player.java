package source;

// player class, would be initialized twice during the game
public class Player {
    // the player's name
    public Character name;
    // the palyer's enemy name
    public Character enemyName;
    // maintain a grid that represents the self ships and ocean
    public selfGrid selfGrid;
    // maintain a grid that represents the enemy ships and ocean
    public enemyGrid enemyGrid;
    // temporary variable, storing the location of the current firing action
    public int[] firedLocation;

    // initialize the self grid, name
    Player(String name){
        this.name = new Character(name.charAt(0));
        this.selfGrid = new selfGrid();
        this.firedLocation = new int[] {-1,-1};
    }

    // the following methods are all wrapper methods to implement the diffrent operations to selfGrid or enemyGrid
    // the detailed implementation would be in Gird class or Ship class
    public String getShipToSet() {
        return selfGrid.getShipToSet();
    }

    public void setShip(int row, int column, char direction){
        selfGrid.setShip(row, column, direction);
    }

    public boolean isFullSetted(){
        return selfGrid.isFull();
    }

    public Character[] getGridConflict(int row, int column, char direction){
        return selfGrid.getConflict(row, column, direction);
    }

    public String displaySelf(){
        return selfGrid.show();
    }

    public void setEnemyName(Character enemyName){
        this.enemyName = enemyName;
    }

    public void setEnemyGrid(selfGrid grid){
        this.enemyGrid = new enemyGrid(grid);
    }

    // display the combined map in the fighting phase
    // the left is selfGrid while the right is enemyGrid
    public String displayAll(){
        String ans = "  0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9";
        ans += "            0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9\n";
        for (int i = 0; i < 20; i++) {
            ans += displayLine(i, selfGrid) + "       " +displayLine(i, enemyGrid);
            ans += "\n";
        }
        ans += "  0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9";
        ans += "            0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9";
        ans += "\n";
        return ans;
    }

    // a helper method for displayAll()
    // print everyline of the combine map
    // determined by the line number (input)
    public String displayLine(int lineNum, Grid grid){
        String ans = "";
        char c = (char) ('A' + lineNum);
        ans += new Character(c).toString();
        for (int j = 0; j < 10; j++) {
            ans += " " + grid.map[lineNum][j].toString();
            if (j != 9) {
                ans += " |";
            }
        }
        ans += " " + c;
        return ans;
    }

    // also wrapper methods
    public boolean hasLost(){
        return this.selfGrid.isAllFall();
    }

    public Character findBlock(int row, int column){
        return this.enemyGrid.findBlock(row, column); // need to find what is going on about the real map of the enemy
    }

    public void fireAt(int row, int column, Character sign){
        this.enemyGrid.fireAt(row, column, sign);
    }

    public void setFiredLocation(int row, int column){
        this.firedLocation[0] = row;
        this.firedLocation[1] = column;
    }

    public int[] getFiredLocation(){
        return this.firedLocation;
    }

    public void updateFire(int[] fireLocation){
        //System.out.println("B is going to update fire");
        this.selfGrid.updateFire(fireLocation);
    }

}