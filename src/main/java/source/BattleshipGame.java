package source;
import java.util.Scanner;
import java.io.*;


public class BattleshipGame {
    public GamePhase phase;
    public Player playerA;
    public Player playerB;
    public Player[] players;

    BattleshipGame(){
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

        // transfer to shipSetting
        phase = phase.updateToShipSetting();
        // in the shipSetting
        for (Player player: players) {
            for (int i = 0; i < 10; i++) {
                phase.printPrompt(player);
                phase.askUser(player);
            }
        }

        //System.out.println(playerA.displaySelf());
        //System.out.println(playerB.displaySelf());
    }
}
