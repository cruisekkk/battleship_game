package source;
import java.io.*;
import java.util.Scanner;

class shipFighting_ask implements Ask {
    @Override
    // in the shipfighting phase
    // the input should be the ship locaiton
    // in this print method: it will validate the input, give the result of fire, store the fire location
    public void print(Player x) {
        String s;
        int check = 0;

        do {
            if (check == 1){
                System.out.println("You should only type one character F, M, or S");
            }
            System.out.println("Possible actions for Player " + x.name + ":");
            System.out.println(" F Fire at a square");
            System.out.println(" M Move a ship to another square (" + x.moveRemainNum + " remaining)");
            System.out.println(" S Sonar scan (" + x.sonarRemainNum + " remaining)");
            System.out.println("Player " + x.name + ", what would you like to do?");
            s = input.reader.nextLine();
            System.out.println(s);
            if (s.length() != 1){
                check = 1;
                continue;
            }
            if (s.toLowerCase().charAt(0) == 'f'){
                fireAction(x);
                break;
            }
            if (s.toLowerCase().charAt(0) == 'm'){
                if (x.moveRemainNum <= 0) {
                    System.out.println("There is no token for you to use Move, remember you can only use it twice!");
                    continue;
                }
                moveAction(x);
                x.moveRemainNum--;
                break;
            }
            if (s.toLowerCase().charAt(0) == 's'){
                if (x.sonarRemainNum <= 0) {
                    System.out.println("There is no token for you to use Sonar, remember you can only use it once!");
                    continue;
                }
                sonarAction(x);
                x.sonarRemainNum--;
                break;
            }
        } while (true);

    }

    @Override
    public void fireAction(Player x){
        String s;
        int check = 0;

        do {
            System.out.println("Player " + x.name + ", where do you want to fire?");
            s = input.reader.nextLine();
            System.out.println(s);
            if (check == 1 && ValidInputStr(s, x) && !ValidInputShip(s, x)){
                System.out.println("You shouldn't put here, The place is filled ");
            }
            check = 1;
        } while (!ValidInputStr(s, x) || !ValidInputShip(s, x));

        int row = (int)(s.toLowerCase().charAt(0) - 'a');
        int column = (int) (s.charAt(1) - '0');

        // process the data
        if (x.findBlock(row, column).equals('s') ){
            x.fireAt(row, column, new Character('s')); // fire at
            System.out.println("You hit a submarine!");
        }
        else if (x.findBlock(row, column).equals('b') ){
            x.fireAt(row, column, new Character('b')); // fire at
            System.out.println("You hit a battleship!");
        }
        else if (x.findBlock(row, column).equals('c') ){
            x.fireAt(row, column, new Character('c')); // fire at
            System.out.println("You hit a carrier!");
        }
        else if (x.findBlock(row, column).equals('d') ){
            x.fireAt(row, column, new Character('d')); // fire at
            System.out.println("You hit a destroyer!");
        }
        else if (x.findBlock(row, column).equals(' ') ){
            x.fireAt(row, column, new Character('X')); // fire at
            System.out.println("You missed!");
        }

        x.setFiredLocation(row, column);
        //System.out.println("setFiredLocation: " + row + ", " + column);

    }

    @Override
    // the proper format is like A0, b9.. only two characters
    public boolean ValidInputStr(String s, Player x){
        if (s.length() != 2){
            System.out.println("You should only put here 2 characters: row char, column number");
            return false;
        }
        if (s.toLowerCase().charAt(0) < 'a' || s.toLowerCase().charAt(0) > 't'){
            System.out.println("the row char should be a-t or A-T");
            return false;
        }
        if (s.charAt(1) < '0' || s.charAt(1) > '9'){
            System.out.println("the column number should be 0-9");
            return false;
        }
        return true;
    }

    @Override
    // to check if the location is already fired by the player
    public boolean ValidInputShip(String s, Player x){
        int row = (int)(s.toLowerCase().charAt(0) - 'a');
        int column = (int) (s.charAt(1) - '0');
        Character blanksig = new Character(' ');
        if (!x.enemyGrid.map[row][column].equals(blanksig)){
            System.out.println("{" + s.toLowerCase().charAt(0) + " , " + column + "} has already be fired and it is not blank" );
            return false;
        }
        return true;
    }


    @Override
    public void sonarAction(Player x){
        int[][] route = new int[][] {{-3,0}, {-2,-1}, {-2,0}, {-2,1}, {-1,-2}, {-1,-1}, {-1,0}, {-1,1}, {-1,2}, {0,-3}, {0,-2}, {0,-1},{0,0},
                {0,1}, {0,2}, {0,3}, {1,-2}, {1,-1}, {1,0}, {1,1}, {1,2}, {2,-1}, {2,0}, {2,1}, {3,0}};
        // visit the enemyGrid unHidMap
        String s;
        int check = 0;

        do {
            System.out.println("Player " + x.name + ", where do you want to use Sonar?");
            s = input.reader.nextLine();
            System.out.println(s);
        } while (!ValidInputStr(s, x));

        int row = (int)(s.toLowerCase().charAt(0) - 'a');
        int column = (int) (s.charAt(1) - '0');

        int sNum = 0;
        int dNum = 0;
        int bNum = 0;
        int cNum = 0;

        for (int[] location: route){
            if (row + location[0] >= 0 && row + location[0] < 10){
                if (column + location[1] >= 0 && column + location[1] < 10){
                    int newRow = row + location[0];
                    int newColumn = column + location[1];
                    if (x.enemyGrid.unHidMap[newRow][newColumn].equals('s')){
                        sNum++;
                    }
                    if (x.enemyGrid.unHidMap[newRow][newColumn].equals('d')){
                        dNum++;
                    }
                    if (x.enemyGrid.unHidMap[newRow][newColumn].equals('b')){
                        bNum++;
                    }
                    if (x.enemyGrid.unHidMap[newRow][newColumn].equals('c')){
                        cNum++;
                    }
                }
            }
        }

        System.out.println("Submarines occupy " + sNum + " squares");
        System.out.println("Destroyers occupy " + dNum + " squares");
        System.out.println("Battleships occupy " + bNum + " squares");
        System.out.println("Carriers occupy " + cNum + " squares");
    }

    @Override
    // move self
    public void moveAction(Player x){
        String s;
        System.out.println("These are the ships that still alive");
        x.displayMoveShips();
        System.out.println("You may type in any coordinate that is part of the ship to a new location");
        do {
            System.out.println("Please type in the coordination of the ship you want to move, any other coordination is invalid ");
            s = input.reader.nextLine();
            System.out.println(s);
            if (x.findShip(s) == -1){
                System.out.println("This is not a ship's coordination");
            }
        }while(!ValidInputStr(s, x) || x.findShip(s) == -1);
        int oldRow = (int)(s.toLowerCase().charAt(0) - 'a');
        int oldColumn = (int) (s.charAt(1) - '0');

        int shipNum = x.findShip(oldRow, oldColumn);

        do {
            System.out.println("Please type in the new coordination and orientation (as the left corner's block)");
            s = input.reader.nextLine();
            System.out.println(s);
        }while(!validMoveinput(s, shipNum) || !validMoveLocation(x, s, shipNum));


    }

    @Override
    public boolean validMoveinput(String s, int shipNum){
        if (s.length() != 3){
            System.out.println("You should only put here 3 characters: row char, column number, direction");
            return false;
        }
        if (s.toLowerCase().charAt(0) < 'a' || s.toLowerCase().charAt(0) > 't'){
            System.out.println("the row char should be a-t or A-T");
            return false;
        }
        if (s.charAt(1) < '0' || s.charAt(1) > '9'){
            System.out.println("the column number should be 0-9");
            return false;
        }
        if (shipNum < 5){
            if (s.toLowerCase().charAt(2) != 'v' && s.toLowerCase().charAt(2) != 'h') {
                Character a = new Character(s.toLowerCase().charAt(2));
                System.out.println(a.toString() + "Submarine or Destroyer's direction should be V(v) or H(h)");
                return false;
            }
            return true;
        }
        if (s.toLowerCase().charAt(2) != 'u' && s.toLowerCase().charAt(2) != 'r' && s.toLowerCase().charAt(2) != 'd' && s.toLowerCase().charAt(2) != 'l') {
            Character a = new Character(s.toLowerCase().charAt(2));
            System.out.println(a.toString() + "Battleship or Carrier's direction should be U(u), R(r), D(d), L(l)");
            return false;
        }
        return true;
    }


    @Override
    public boolean validMoveLocation(Player x, String s, int shipNum){
        int row = (int)(s.toLowerCase().charAt(0) - 'a');
        int column = (int) (s.charAt(1) - '0');
        char direction = s.toLowerCase().charAt(2);
        Character unblanksig = new Character('x');
        Character outOfIndex = new Character('o');
        Character[] conflictLoc = x.getGridConflict(row, column, direction, shipNum);
        if (conflictLoc[1].equals(outOfIndex)){
            System.out.println("Out of index, be careful");
            System.out.println("Please input the place again");
            return false;
        }
        if (!conflictLoc[1].equals(unblanksig)){
            System.out.println("Conflict on {" + conflictLoc[0].toString() + "," +  conflictLoc[1].toString() + "}");
            System.out.println("Please input the place again");
            System.out.println("\n");
            return false;
        }
        return true;
    }
}