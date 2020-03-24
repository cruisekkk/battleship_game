package source;

class Carrier extends Ship {
    Carrier(int row, int column, char direction) {
        this.pivot = new int[]{row, column};
        this.direction = direction;
        this.blocks = 6;
        this.name = new Character('c');
        initRoute(direction);
    }

    @Override
    boolean isFall(){
        return false;
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
}