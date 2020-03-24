package source;

class Submarine extends Ship{
    Submarine(int row, int column, char direction){
        this.pivot = new int[]{row, column};
        this.direction = direction;
        this.blocks = 2;
        this.name = new Character('s');
        initRoute(direction);
    }

    @Override
    boolean isFall(){
        return false;
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
}