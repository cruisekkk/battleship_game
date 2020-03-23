package source;

public class Player {
    public int shipNum;
    public String name;
    public String[] shipToset;

    Player(String name){
        this.name = name;
        this.shipNum = 0;
        this.shipToset = new String[] {"", "Submarines", "Submarines", "Destroyers"};
    }

    boolean isFullSetted(){
        return false;
    }

    String getShipToSet(){
        return shipToset[shipNum];
    }
}