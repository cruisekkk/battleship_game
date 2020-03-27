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
            System.out.println("Player " + x.name + " where do you want to fire ?");
            s = input.reader.nextLine();
            System.out.println(s);
            if (check == 1 && ValidInputStr(s) && !ValidInputShip(s, x)){
                System.out.println("You shouldn't put here, The place is filled ");
            }
            check = 1;
        } while (!ValidInputStr(s) || !ValidInputShip(s, x));

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
    public boolean ValidInputStr(String s){
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

}