package source;

// Design pattern: visitor
// invoke print and ask module by the first two methods
// two phase transition method
interface GamePhase {
    void printPrompt(Player x);
    void askUser(Player x);
    GamePhase updateToShipSetting();
    GamePhase updateToShipFighting();
}
