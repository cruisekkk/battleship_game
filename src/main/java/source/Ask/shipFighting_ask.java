package source;
import java.io.*;
import java.util.Scanner;

class shipFighting_ask implements Ask {
    @Override
    public void print(Player x) {

    }

    @Override
    public boolean ValidInputStr(String s){
        return true;
    }

    @Override
    public boolean ValidInputShip(String s, Player x){
        return true;
    }

}