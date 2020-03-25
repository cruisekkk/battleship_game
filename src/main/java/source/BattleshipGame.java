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
            //while(!player.isFullSetted()){
                phase.printPrompt(player);
                phase.askUser(player); // where do you want to put
            //}
        }

        // transfer to fighting phase
        phase = phase.updateToShipFighting();
        // set mutual name
        players[0].setEnemyName(players[1].name);
        players[1].setEnemyName(players[0].name);
        // set mutual Grid
        //players[0].setEnemyGrid(players[1].selfGrid);
        //players[1].setEnemyGrid(players[0].selfGrid);


        //while(1){
        phase.printPrompt(players[0]);

        //}
    }
}
