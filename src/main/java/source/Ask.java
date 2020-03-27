package source;
// Ask is an interface class
// There are three sub phases class can implement Ask
// start_ask, shipSetting_ask, shipFighting_ask
// They have the similar behavior as they need those three methods


interface Ask {
    // print would ask the user and give the proper response in the terminal
    void print(Player x);
    // this validate the input string
    boolean ValidInputStr(String s);
    // this validate the logic of player's choice
    boolean ValidInputShip(String s, Player x);
}