package source;

class Destroyer extends Ship {
    Destroyer(int row, int column, char direction) {
        this.pivot = new int[]{row, column};
        this.direction = direction;
        this.blocks = 3;
        this.name = new Character('d');
        initRoute(direction);
    }

    @Override
    boolean isFall(){
        return false;
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
}