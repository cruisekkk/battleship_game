package source;

public class Player {
    public Character name;
    public selfGrid selfGrid;
    public enemyGrid enemyGrid;

    Player(String name){
        this.name = new Character(name.charAt(0));
        this.selfGrid = new selfGrid();
        this.enemyGrid = new enemyGrid();
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


}