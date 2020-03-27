package source;

class start_prompt implements Prompt {
    @Override
    // the prompt in the start phase
    public void print(Player x) {
        String n = "";
        n += "      Welcome to the game < Battleship> !\n\n";
        n += "This is a strategy type guessing game for two players.\n";
        n += "  To know more about this game, please look here:\n";
        n += "  https://en.wikipedia.org/wiki/Battleship_(game)\n";
        n += "\n";
        n += "           Are you ready?";
        System.out.println(n);
    }
}
