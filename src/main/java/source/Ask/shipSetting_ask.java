package source;
import java.io.*;
import java.util.Scanner;

class shipSetting_ask implements Ask {
    @Override
    public void print(Player x) {
        String s;
        do {
            System.out.println("Player " + x.name + " where do you want to place "); //+ x.getShipToSet());
            s = input.reader.nextLine();
            System.out.println(s);
        } while (!s.toLowerCase().equals("yes") && !s.toLowerCase().equals("no") );

        if (s.toLowerCase().equals("no")){
            System.exit(0);
        }

    }
}