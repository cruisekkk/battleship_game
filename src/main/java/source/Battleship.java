package source;
import java.util.Scanner;
import java.io.*;


public class Battleship {
    public GamePhase phase;
    public Player playerA;
    public Player playerB;
    public Player[] players;

    Battleship(){
        CreateGamePhase();
        CreatePlayers();
    }

    void CreateGamePhase(){
        phase = new Start();
    }

    void CreatePlayers(){
        playerA = new Player("A");
        playerB = new Player("B");
        players = new Player[] {playerA, playerB};
    }

    void play() throws IOException{
        System.out.println("Game start!\n");
        // in the start interface
        phase.printPrompt(playerA);
        phase.askUser(playerA);
        // if the user is not ready, the game will quit

        // in the shipsetting
        phase = phase.updateToShipSetting();

        for (Player player: players) {
            phase.printPrompt(player);
        }
    }
}
