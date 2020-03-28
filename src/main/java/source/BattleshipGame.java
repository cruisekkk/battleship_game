package source;
import java.util.Scanner;
import java.io.*;


public class BattleshipGame {
    public GamePhase phase;
    public Player playerA;
    public Player playerB;
    public Player[] players;

    BattleshipGame() {
        CreateGamePhase();
        CreatePlayers();
    }

    // initialize the phase object : a start phase
    void CreateGamePhase() {
        phase = new Start();
    }

    // create two players
    void CreatePlayers() {
        playerA = new Player("A");
        playerB = new Player("B");
        players = new Player[]{playerA, playerB};
    }

    void play() throws IOException {
        System.out.println("Game start!\n");
        // in the start interface
        phase.printPrompt(playerA);
        phase.askUser(playerA);
        // if the user is not ready, the game will quit

        // ask which mode
        //int mode = 0;
        System.out.println("We provide two modes in the game");
        System.out.println("1: human vs human");
        System.out.println("2: human vs computer");
        String s = "";
        do {
            System.out.println("[1/2] :Enter the mode you want to play in");
            s = input.reader.nextLine();
            System.out.println(s);
            if (s.length() != 1){
                System.out.println("you can only put 1 number here, please enter it again");
            }
        } while (s.length()!=1 || (s.charAt(0)!= '1' && s.charAt(0)!='2'));

        if (s.charAt(0) == '2'){ // auto play
            autoplay();
            return;
        }

        // transfer to shipSetting
        phase = phase.updateToShipSetting();
        // in the shipSetting
        for (Player player : players) {
            while(!player.isFullSetted()){
            phase.printPrompt(player);
            phase.askUser(player); // where do you want to put
            }
        }

        // transfer to fighting phase
        phase = phase.updateToShipFighting();
        // set mutual name
        players[0].setEnemyName(players[1].name);
        players[1].setEnemyName(players[0].name);
        // set mutual Grid
        players[0].setEnemyGrid(players[1].selfGrid);
        players[1].setEnemyGrid(players[0].selfGrid);

        // the logic loop in the fighting phase
        while (true) {
            phase.printPrompt(players[0]);
            phase.askUser(players[0]); // change the enemy

            players[1].updateFire(players[0].getFiredLocation());
            players[1].enemyGrid.unHidMap = players[0].selfGrid.map;

            if (players[1].hasLost()) { // depends on the self
                System.out.println("Game Over \nPlayer " + players[0].name + " has won!");
                break;
            }
            phase.printPrompt(players[1]);
            phase.askUser(players[1]);

            players[0].updateFire(players[1].getFiredLocation());
            players[0].enemyGrid.unHidMap = players[1].selfGrid.map;

            if (players[0].hasLost()) { // depends on the enemy
                System.out.println("Game Over \nPlayer " + players[1].name + " has won!");
                break;
            }
        }
    }

    void autoplay() throws IOException {





        return;
    }

}