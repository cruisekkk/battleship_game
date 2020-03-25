package source;

class Battleship extends Ship {
    Battleship(int row, int column, char direction) {
        this.pivot = new int[]{row, column};
        this.direction = direction;
        this.blocks = 4;
        this.name = new Character('b');
        initRoute(direction);
        initMap();
    }

    @Override
    boolean isFall(){
        for (int i = 0; i < this.blocks; ++i) {
            if (!this.shipMap[this.route[i][0]][this.route[i][1]].equals('*')){
                return false;
            }
        }
        return true;
    }

    @Override
    void initRoute(char direction){
        if (direction == 'h'){
            this.route = new int[][] {{0,0}, {0,1}, {0,2}, {0,3}};
        }

        if (direction == 'v'){
            this.route = new int[][] {{0,0}, {1,0}, {2,0}, {3,0}};
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