package source;
import java.io.*;
import java.util.Scanner;

class shipSetting_ask implements Ask {
    @Override
    public void print(Player x) {
        String s;
        int check = 0;

        do {
            System.out.println("Player " + x.name + " where do you want to place a " + x.getShipToSet());
            s = input.reader.nextLine();
            System.out.println(s);
            if (check == 1 && ValidInputStr(s) && !ValidInputShip(s, x)){
                System.out.println("You shouldn't put here, The place is filled ");
            }
            check = 1;
        } while (!ValidInputStr(s) || !ValidInputShip(s, x));

        int row = (int)(s.toLowerCase().charAt(0) - 'a');
        int column = (int) (s.charAt(1) - '0');
        char direction = s.toLowerCase().charAt(2);
        x.setShip(row, column, direction); // set the players' selfgrid

    }
    @Override
    public boolean ValidInputStr(String s){
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
        if (s.toLowerCase().charAt(2) != 'v' && s.toLowerCase().charAt(2) != 'h'){
            Character a = new Character(s.toLowerCase().charAt(2));
            System.out.println( a.toString() + "the direction should be V(v) or H(h)");
            return false;
        }
        return true;
    }

    @Override
    public boolean ValidInputShip(String s, Player x)
    {   int row = (int)(s.toLowerCase().charAt(0) - 'a');
        int column = (int) (s.charAt(1) - '0');
        char direction = s.toLowerCase().charAt(2);
        Character unblanksig = new Character('x');

        Character[] conflictLoc = x.getGridConflict(row, column, direction);
        if (!conflictLoc[1].equals(unblanksig)){
            System.out.println("Conflict on {" + conflictLoc[0].toString() + "," +  conflictLoc[1].toString() + "}");
            System.out.println("Please input the place again");
            System.out.println("\n");
            return false;
        }

        return true;
    }
}