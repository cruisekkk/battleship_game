package source;

interface GamePhase {
    void printPrompt(Player x);
    void askUser(Player x);
    GamePhase updateToShipSetting();
    GamePhase updateToShipFighting();
}
