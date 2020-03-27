package source;

// a sub class of Grid
// maintain the map data during shipsettin and ship fighting
public class selfGrid extends Grid {
    // use the same initializer from Grid
    // generate an empty map
    selfGrid(){
        super();
    }

    // initialize the following ships in order
    // return the required ship type to IO module
    public String getShipToSet() {
        if (shipNum < 2) {
            return "Submarine";
        }
        if (shipNum >= 2 && shipNum < 5) {
            return "Destroyer";
        }
        if (shipNum >= 5 && shipNum < 8) {
            return "Battleship";
        }
        return "Carrier";
    }

    // Receive the location from ask module, initialize the proper ship in the location
    void setShip(int row, int column, char direction) {
        // init
        if (shipNum < 2) {
            shipList[shipNum] = new Submarine(row, column, direction);
        }
        if (shipNum >= 2 && shipNum < 5) {
            shipList[shipNum] = new Destroyer(row, column, direction);
        }
        if (shipNum >= 5 && shipNum < 8) {
            shipList[shipNum] = new Battleship(row, column, direction);
        }
        if (shipNum >= 8 && shipNum < 10) {
            shipList[shipNum] = new Carrier(row, column, direction);
        }
        // void
        drawShipOnMap(shipList[shipNum]);
        shipNum = shipNum + 1;
    }

    // update the ship's location on the map in the setting phase
    void drawShipOnMap(Ship ship) {
        for (int i = 0; i < ship.blocks; ++i) {
            map[ship.pivot[0] + ship.route[i][0]][ship.pivot[1] + ship.route[i][1]] = ship.name;
        }
    }

    @Override
    // display the map before the player input
    // connected to the print prompt module
    public String show() {
        String ans = "  0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9  \n";
        for (int i = 0; i < 20; i++) {
            char c = (char) ('A' + i);
            ans += new Character(c).toString();
            for (int j = 0; j < 10; j++) {
                ans += " " + map[i][j].toString();
                if (j != 9) {
                    ans += " |";
                }
            }
            ans += " " + c + "\n";
        }
        ans += "  0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9  \n";
        ans += "\n";
        return ans;
    }

    // determine if there is a conflict between the planned location and map
    // if conflict, return the real conflicted location
    // if not, return {x,x}
    public Character[] getConflict(int row, int column, char direction) {
        Ship ship = new Submarine(row, column, direction);
        if (shipNum >= 2 && shipNum < 5) {
            ship = new Destroyer(row, column, direction);
        }
        if (shipNum >= 5 && shipNum < 8) {
            ship = new Battleship(row, column, direction);
        }
        if (shipNum >= 8 && shipNum < 10) {
            ship = new Carrier(row, column, direction);
        }
        Character blank = new Character(' ');
        for (int i = 0; i < ship.blocks; ++i) {
            int searchRow = ship.pivot[0] + ship.route[i][0];
            int searchColumn = ship.pivot[1] + ship.route[i][1];
            System.out.println("search area situation: " + map[searchRow][searchColumn].toString());
            if (!map[searchRow][searchColumn].equals(blank)) {
                return new Character[]{(char) (row + 'A'), (char) (column + '0')};
            }
        }

        return new Character[]{'x', 'x'};
    }

    // determine if the ship is full setted as a sign to end setting phase
    public boolean isFull() {
        if (this.shipNum == 10) {
            return true;
        }
        return false;
    }

    // determine if the ships in the list is all "fall", meaning killed by the enemy
    public boolean isAllFall(){
        //for (Ship ship: this.shipList){
        for (int i = 0; i < this.shipNum; i++){
            if (!shipList[i].isFall()){
                return false;
            }
        }
        return true;
    }

    // a helper funciton for updateFire()
    // find the ship(exact object) who has that block
    // the input is the block's location
    public int findShip(int row, int column){
        for (int i = 0; i < this.shipNum; i++){
            //System.out.println(this.shipNum);
            if (shipList[i].hasBlock(row, column)){
                return i;
            }
        }
        return -1;
    }

    // receive the fired location by IO module(passing by the enemy)
    // update to the map and the ship
    public void updateFire(int[] fireLocation){
        int row = fireLocation[0];
        int column = fireLocation[1];
        //System.out.println("the fire location in B is " + row + ", " + column);
        // no ship
        if (findShip(row, column) == -1){
            //System.out.println("there is no ship");
            return;
        }

        // find the ship, fire
        int shipNumber = findShip(row, column);
        this.map[row][column] = new Character('*');
        this.shipList[shipNumber].updateFire(row, column);
    }


}