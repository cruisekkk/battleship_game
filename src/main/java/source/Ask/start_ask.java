package source;
import java.io.*;
import java.util.Scanner;

class start_ask implements Ask {
    @Override
    public void print(Player x) {
        String s;
        Scanner reader = new Scanner(System.in);  // Reading from System.in
        do {
            System.out.println("[yes/no] Enter: ");
            s = reader.nextLine();
            System.out.println(s);
        } while (!s.toLowerCase().equals("yes") && !s.toLowerCase().equals("no") );
        reader.close();

        if (s.toLowerCase().equals("no")){
            System.exit(0);
        }
    }
}