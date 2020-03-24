package source;

public class Grid {
    public int shipNum;
    public Character[][] map;
    //public Ship[] shipToset;
    Grid(){
        mapInit();
        //this.shipToset = new Ship[] {};
        this.map = new Character[20][10];
        for (int i = 0; i < 20; i++){
            for (int j = 0; j < 10; j++){
                map[i][j] = ' ';
            }
        }
    }

    public String show(){
        String ans = "  0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9  \n";
        for (int i = 0; i < 20; i++){
            char c = (char)('A' + i);
            ans += new Character(c).toString();
            for (int j = 0; j < 10; j++){

                ans += " " + map[i][j].toString();
                if (j !=9){
                    ans += " |";
                }

            }
            ans += " " + c+ "\n";
        }
        ans += "  0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9  \n";
        return ans;
    }

    public void mapInit(){
        //this.map = " 0|1|2|3|4|5|6|7|8|9 \n";
        //this.map +=
    }
}