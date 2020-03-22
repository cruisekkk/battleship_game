package source;

public class Battleship {
    public GamePhase phase;
    public Player playerA;
    public Player playerB;

    Battleship(){
        CreateGamePhase();
        CreatePlayers();
    }

    void CreateGamePhase(){
        phase = new GamePhase();
    }

    void CreatePlayers(){
        playerA = new Player();
        playerB = new Player();
    }

    void play(){
        System.out.println("Game start!");
    }
}
