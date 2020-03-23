package source;

public class Player {
    public int shipNum;
    public String name;
    public String[] shipToset;
    public Grid selfGrid;
    public Grid enemyGrid;

    Player(String name){
        this.name = name;
        this.shipNum = 0;
        this.selfGrid = new Grid();
        this.enemyGrid = new Grid();
        this.shipToset = new String[] {"", "Submarines", "Submarines", "Destroyers"};
    }

    boolean isFullSetted(){
        return false;
    }

    String getShipToSet(){
        return shipToset[shipNum];
    }

    String displaySelf(){
        return selfGrid.show();
    }
}