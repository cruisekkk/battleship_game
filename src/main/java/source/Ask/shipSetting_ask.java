package source;
import java.io.*;
import java.util.Scanner;

class shipSetting_ask implements Ask {
    @Override
    // in the shipsetting phase
    // the input should be the ship locaiton and direction
    public void print(Player x) {
        String s;
        int check = 0;

        do {
            System.out.println("Player " + x.name + " where do you want to place a " + x.getShipToSet());
            s = input.reader.nextLine();
            System.out.println(s);
            //if (check == 1 && ValidInputStr(s) && !ValidInputShip(s, x)){
            //    System.out.println("You shouldn't put here, The place is filled ");
            //}
            //check = 1;
        } while (!ValidInputStr(s, x) || !ValidInputShip(s, x));

        int row = (int)(s.toLowerCase().charAt(0) - 'a');
        int column = (int) (s.charAt(1) - '0');
        char direction = s.toLowerCase().charAt(2);
        x.setShip(row, column, direction); // set the players' selfgrid
    }

    @Override
    // tolerate the upper or lower case
    // can just handle 3 characters
    public boolean ValidInputStr(String s, Player x){ //shipNum < 5
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
        if (x.selfGrid.shipNum < 5){
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
    // two parameters: input, player
    // use the input to visit the player's data structure
    // check if there is conflict of the existing ships on the map
    public boolean ValidInputShip(String s, Player x)
    {   int row = (int)(s.toLowerCase().charAt(0) - 'a');
        int column = (int) (s.charAt(1) - '0');
        char direction = s.toLowerCase().charAt(2);
        Character unblanksig = new Character('x');
        Character outOfIndex = new Character('o');
        Character[] conflictLoc = x.getGridConflict(row, column, direction);
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

    @Override
    public void fireAction(Player x){

    }
}