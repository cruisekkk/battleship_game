package source;

class Destroyer extends Ship {
    Destroyer(int row, int column, char direction) {
        this.pivot = new int[]{row, column};
        this.direction = direction;
        this.blocks = 3;
        this.name = new Character('d');
        initRoute(direction);
        initMap();
    }

    @Override
    void initRoute(char direction){
        if (direction == 'h'){
            this.route = new int[][] {{0,0}, {0,1}, {0,2}};
        }

        if (direction == 'v'){
            this.route = new int[][] {{0,0}, {1,0}, {2,0}};
        }
    }

    @Override
    void initMap(){
        this.shipMap = new Character[6][6];
        for (int i = 0; i < 3; ++i){
            for (int j = 0; j < 3; ++j){
                this.shipMap[i][j] = ' ';
            }
        }
        for (int i = 0; i < this.blocks; ++i){
            this.shipMap[this.route[i][0]][this.route[i][1]] = 'd';
        }
    }

}