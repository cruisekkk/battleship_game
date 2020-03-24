package source;

public class Player {
    public String name;
    public Grid selfGrid;
    public Grid enemyGrid;

    Player(String name){
        this.name = name;
        this.selfGrid = new Grid();
        this.enemyGrid = new Grid();
    }

    boolean isFullSetted(){
        return false;
    }

    String displaySelf(){
        return selfGrid.show();
    }
}