package source;

abstract class Ship{
    public Character name;
    public int[] pivot; // like [3,1] the left corner
    public String type;
    public char direction;
    public Character[][] shipMap;
    public int blocks;
    public int[][] route; // record the change based on pivot, for example, the original plce is [0][0], the right is [0][1]
    abstract void initRoute(char direction);
    abstract void initMap();

    boolean hasBlock(int row, int column){
        //System.out.println("the row and column is " + row + ", " + column);
        //System.out.println(this.blocks + "blocks");
        for (int i = 0; i < this.blocks; ++i) {
            //System.out.println("the route is "+ route[i][0] + ", " + route[i][1]);
            //System.out.println("the pivot is "+ pivot[0] + ", " + pivot[1]);
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

    boolean isFall(){
        for (int i = 0; i < this.blocks; ++i) {
            if (!this.shipMap[this.route[i][0]][this.route[i][1]].equals('*')){
                return false;
            }
        }
        return true;
    }
}