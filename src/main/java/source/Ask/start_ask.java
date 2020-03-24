package source;
import java.io.*;
import java.util.Scanner;

class start_ask implements Ask {
    @Override
    public void print(Player x) {
        String s;
        //Scanner reader = new Scanner(System.in);  // Reading from System.in
        do {
            System.out.println("[yes/no] Enter: ");
            s = input.reader.nextLine();
            System.out.println(s);
        } while (! ValidInputStr(s));

        if (s.toLowerCase().equals("no")){
            System.exit(0);
        }
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