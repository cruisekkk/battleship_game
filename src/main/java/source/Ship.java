package source;

abstract class Ship{
    public Character name;
    public int[] pivot; // like [3,1] the left corner
    public String type;
    public char direction;
    public Character[][] shipMap;
    public int blocks;
    public int[][] route; // record the change based on pivot, for example, the original plce is [0][0], the right is [0][1]
    abstract boolean isFall();
    abstract void initRoute(char direction);
    abstract void initMap();

    boolean hasBlock(int row, int column){
        for (int i = 0; i < this.blocks; ++i) {
            if (this.route[i][0] + this.pivot[0] == row){
                if (this.route[i][1] + this.pivot[1] == column){
                    return true;
                }
            }
        }
        return false;
    }

    void updateFire(int row, int column){
        this.shipMap[row - pivot[0]][column - pivot[1]] = new Character('*');
    }

}