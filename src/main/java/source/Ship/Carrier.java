package source;

class Carrier extends Ship {
    Carrier(int row, int column, char direction) {
        this.pivot = new int[]{row, column};
        this.direction = direction;
        this.blocks = 6;
        this.name = new Character('c');
        initRoute(direction);
        initMap();
    }


    @Override
    void initRoute(char direction){
        if (direction == 'h'){
            this.route = new int[][] {{0,0}, {0,1}, {0,2}, {0,3}, {0,4}, {0,5}};
        }

        if (direction == 'v'){
            this.route = new int[][] {{0,0}, {1,0}, {2,0}, {3,0}, {4,0}, {5,0}};
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