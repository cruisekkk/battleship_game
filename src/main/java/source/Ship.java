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
}