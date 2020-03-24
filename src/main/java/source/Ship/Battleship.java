package source;

class Battleship extends Ship {
    Battleship(int row, int column, char direction) {
        this.pivot = new int[]{row, column};
        this.direction = direction;
        this.blocks = 4;
        this.name = new Character('b');
        initRoute(direction);
    }

    @Override
    boolean isFall(){
        return false;
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
}