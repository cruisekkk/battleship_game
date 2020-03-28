package source;
// will show 'c' in the map
// has six blocks

// version 2
class Carrier extends Ship {
    Carrier(int row, int column, char direction) {
        this.pivot = new int[]{row, column};
        this.direction = direction;
        this.blocks = 6;
        this.name = new Character('c');
        this.type = new String("Carrier");
        initRoute(direction);
        initMap();
    }


    @Override
    void initRoute(char direction){
        if (direction == 'u'){
            this.route = new int[][] {{0,0}, {1,0}, {2,0}, {2,1}, {3,1}, {4,1}};
        }

        if (direction == 'r'){
            this.route = new int[][] {{1,0}, {1,1}, {1,2}, {0,2}, {0,3}, {0,4}};
        }

        if (direction == 'd'){
            this.route = new int[][] {{4,0}, {3,0}, {2,0}, {2,1}, {1,1}, {0,1}};
        }

        if (direction == 'l'){
            this.route = new int[][] {{1,4}, {1,3}, {1,2}, {0,2}, {0,1}, {0,0}};
        }
    }


    @Override
    void initMap(){
        this.shipMap = new Character[6][6];
        for (int i = 0; i < 6; ++i){
            for (int j = 0; j < 6; ++j){
                this.shipMap[i][j] = ' ';
            }
        }
        for (int i = 0; i < this.blocks; ++i){
            this.shipMap[this.route[i][0]][this.route[i][1]] = 'c';
        }
    }
}