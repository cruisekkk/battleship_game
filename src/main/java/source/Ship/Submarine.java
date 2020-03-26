package source;

class Submarine extends Ship{
    Submarine(int row, int column, char direction){
        this.pivot = new int[]{row, column};
        this.direction = direction;
        this.blocks = 2;
        this.name = new Character('s');
        initRoute(direction);
        initMap();
    }


    @Override
    void initRoute(char direction){
        if (direction == 'h'){
            this.route = new int[][] {{0,0}, {0,1}};
        }

        if (direction == 'v'){
            this.route = new int[][] {{0,0}, {1,0}};
        }
    }

    @Override
    void initMap(){
        this.shipMap = new Character[2][2];
        for (int i = 0; i < 2; ++i){
            for (int j = 0; j < 2; ++j){
                this.shipMap[i][j] = ' ';
            }
        }

        for (int i = 0; i < this.blocks; ++i){
            this.shipMap[this.route[i][0]][this.route[i][1]] = 's';
        }
    }
}
