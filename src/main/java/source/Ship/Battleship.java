package source;
// will show 'b' in the map
// has four blocks

// version 2
class Battleship extends Ship {
    Battleship(int row, int column, char direction) {
        this.pivot = new int[]{row, column};
        this.direction = direction;
        this.blocks = 4;
        this.type = new String("Battleship");
        this.name = new Character('b');
        initRoute(direction);
        initMap();
    }

    @Override
    void initRoute(char direction){
        if (direction == 'u'){
            this.route = new int[][] {{0,1}, {1,0}, {1,1}, {1,2}};
        }

        if (direction == 'l'){
            this.route = new int[][] {{1,0}, {0,1}, {1,1}, {2,1}};
        }

        if (direction == 'r'){
            this.route = new int[][] {{1,1}, {0,0}, {1,0}, {2,0}};
        }

        if (direction == 'd'){
            this.route = new int[][] {{1,1}, {0,2}, {0,1}, {0,0}};
        }
    }

    @Override
    void initMap(){
        this.shipMap = new Character[4][4];
        for (int i = 0; i < 4; ++i){
            for (int j = 0; j < 4; ++j){
                this.shipMap[i][j] = ' ';
            }
        }
        for (int i = 0; i < this.blocks; ++i){
            this.shipMap[this.route[i][0]][this.route[i][1]] = 'b';
        }
    }

}