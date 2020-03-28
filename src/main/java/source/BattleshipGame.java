package source;
import javax.swing.*;
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
        phase = new source.Start();
    }

    // create two players
    void CreatePlayers() {
        playerA = new Player("A");
        playerB = new Player("B");
        players = new Player[]{playerA, playerB};
    }

    void play() throws IOException {
        //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        //SwingUtilities.invokeLater();
        JFrameDemo myGUI = new JFrameDemo();
        //myGUI.setVisible(true);


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
//        do {
//            System.out.println("[1/2] :Enter the mode you want to play in");
//            s = input.reader.nextLine();
//            System.out.println(s);
//            if (s.length() != 1){
//                System.out.println("you can only put 1 number here, please enter it again");
//            }
//
//        } while (s.length()!=1 || (s.charAt(0)!= '1' && s.charAt(0)!='2'));
        System.out.println(myGUI.MODE);
        while(true){
            System.out.println(myGUI.MODE);
            if (myGUI.MODE != 0){
                System.out.println(myGUI.MODE);
                break;
            }
        }
        System.out.println(myGUI.MODE);
        System.out.println("here!!!!!!!!!!!!");
        if (myGUI.MODE ==1 || s.charAt(0) == '2'){ // auto play
            System.out.println("into auto play");
            autoplay();
            return;
        }
        System.out.println("jump to here!!!!!!!!!!!!");
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

        // transfer to shipSetting
        phase = phase.updateToShipSetting();
        // in the shipSetting
        // player B is the compute
        // index it by players[1]
        while(!players[0].isFullSetted()){
            phase.printPrompt(players[0]);
            phase.askUser(players[0]); // where do you want to put
        }

        // auto-set the 10 ships
        players[1].setShip(0,0,'v');
        players[1].setShip(0,1,'v');
        players[1].setShip(0,2,'v');
        players[1].setShip(0,3,'v');
        players[1].setShip(0,4,'v');
        players[1].setShip(0,5, 'r');
        players[1].setShip(0,7, 'l');
        players[1].setShip(4,0, 'l');
        players[1].setShip(4,3, 'u');
        players[1].setShip(4,5, 'd');


        // transfer to fighting phase
        phase = phase.updateToShipFighting();
        // set mutual name
        players[0].setEnemyName(players[1].name);
        players[1].setEnemyName(players[0].name);
        // set mutual Grid
        players[0].setEnemyGrid(players[1].selfGrid);
        players[1].setEnemyGrid(players[0].selfGrid);


        // the logic loop in the fighting phase
        int count = 0;
        while (true) {
            phase.printPrompt(players[0]);
            phase.askUser(players[0]); // change the enemy

            players[1].updateFire(players[0].getFiredLocation());
            players[1].enemyGrid.unHidMap = players[0].selfGrid.map;

            if (players[1].hasLost()) { // depends on the self
                System.out.println("Game Over \nPlayer " + players[0].name + " has won!");
                break;
            }

            autofire(count/10, count%10, players[1]);
            players[0].updateFire(players[1].getFiredLocation());
            players[0].enemyGrid.unHidMap = players[1].selfGrid.map;

            if (players[0].hasLost()) { // depends on the enemy
                System.out.println("Game Over \nPlayer " + players[1].name + " has won!");
                break;
            }
            count++;
            if (count == 200){
                count = 0;
            }
        }
        return;
    }

    public void autofire(int row, int column, Player x){
        // fire
        if (x.findBlock(row, column).equals('s') ){
            x.fireAt(row, column, new Character('s')); // fire at
            System.out.println("You hit a submarine!");
        }
        else if (x.findBlock(row, column).equals('b') ){
            x.fireAt(row, column, new Character('b')); // fire at
            System.out.println("You hit a battleship!");
        }
        else if (x.findBlock(row, column).equals('c') ){
            x.fireAt(row, column, new Character('c')); // fire at
            System.out.println("You hit a carrier!");
        }
        else if (x.findBlock(row, column).equals('d') ){
            x.fireAt(row, column, new Character('d')); // fire at
            System.out.println("You hit a destroyer!");
        }
        else if (x.findBlock(row, column).equals(' ') ){
            x.fireAt(row, column, new Character('X')); // fire at
            System.out.println("You missed!");
        }

        x.setFiredLocation(row, column);
    }
}