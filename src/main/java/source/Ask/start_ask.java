package source;
import java.io.*;
import java.util.Scanner;

class start_ask implements Ask {
    @Override
    // print function is basically a loop
    // when the input is valid, jump out of the loop
    // when the input is not valid, continue print the hint
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
    // the only two valid string is yes and no
    public boolean ValidInputStr(String s){
        return (s.toLowerCase().equals("yes") || s.toLowerCase().equals("no"));
    }

    @Override
    // in the start phase, we do not need ship checking process
    public boolean ValidInputShip(String s, Player x){
        return true;
    }
}