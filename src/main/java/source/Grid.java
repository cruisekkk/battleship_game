package source;

public class Grid {
    public int shipNum;
    public Character[][] map;
    public Ship[] shipList;
    Grid(){
        this.shipNum = 0;
        mapInit();
        this.shipList = new Ship[10];
        this.map = new Character[20][10];
        for (int i = 0; i < 20; i++){
            for (int j = 0; j < 10; j++){
                map[i][j] = ' ';
            }
        }
    }

    void setShip(int row, int column, char direction) { // From ask module
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
        drawShip(shipList[shipNum]);
        shipNum = shipNum + 1;
    }

    void drawShip(Ship ship){
        for (int i = 0; i < ship.blocks; ++i){
            map[ship.pivot[0] + ship.route[i][0]][ship.pivot[1] + ship.route[i][1]] = ship.name;
        }

    }

    public String show(){
        String ans = "  0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9  \n";
        for (int i = 0; i < 20; i++){
            char c = (char)('A' + i);
            ans += new Character(c).toString();
            for (int j = 0; j < 10; j++){

                ans += " " + map[i][j].toString();
                if (j !=9){
                    ans += " |";
                }

            }
            ans += " " + c+ "\n";
        }
        ans += "  0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9  \n";
        ans += "\n";
        return ans;
    }

    public void mapInit(){
        //this.map = " 0|1|2|3|4|5|6|7|8|9 \n";
        //this.map +=
    }

    public String getShipToSet(){
        if (shipNum < 2) {
            return "Submarine";
        }
        if (shipNum >= 2 && shipNum < 5) {
            return "Destroyer";
        }
        if (shipNum >= 5 && shipNum < 8) {
            return "Battleships";
        }
        //if (shipNum >= 8 && shipNum < 10) {
        return "Carrier";
        //}

    }
}