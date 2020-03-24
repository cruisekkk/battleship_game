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
        return (s.toLowerCase().equals("yes") || !s.toLowerCase().equals("no"));
    }

    @Override
    public boolean ValidInputShip(String s, Player x){
        return true;
    }
}