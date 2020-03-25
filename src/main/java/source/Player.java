package source;

public class Player {
    public Character name;
    public Grid selfGrid;
    public Grid enemyGrid;

    Player(String name){
        this.name = new Character(name.charAt(0));
        this.selfGrid = new Grid();
        this.enemyGrid = new Grid();
    }

    public void setShip(int row, int column, char direction){
        selfGrid.setShip(row, column, direction);
    }

    public boolean isFullSetted(){
        return selfGrid.isFull();
    }

    public String displaySelf(){
        return selfGrid.show();
    }
    public String getShipToSet() {
        return selfGrid.getShipToSet();
    }

    public Character[] getGridConflict(int row, int column, char direction){
        return selfGrid.getConflict(row, column, direction);
    }
}