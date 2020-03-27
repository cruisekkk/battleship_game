package source;

public class Player {
    public Character name;
    public Character enemyName;
    public selfGrid selfGrid;
    public enemyGrid enemyGrid;
    public int[] firedLocation;

    Player(String name){
        this.name = new Character(name.charAt(0));
        this.selfGrid = new selfGrid();
        this.firedLocation = new int[] {-1,-1};
    }

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