package source;

class shipFighting_prompt implements Prompt {
    @Override
    // the prompt in the shipSetting phase
    // in this phase, the prompt would display the combined ocean of the two players
    // It would invoke the displayAll() function in the player
    // use the player's name and enemy's name
    public void print(Player x) {
        String n = "Player " + x.name + "'s turn:\n";
        n += "   Your ocean                                   Player " + x.enemyName + "'s ocean\n";
        n += x.displayAll();
        System.out.println(n);
    }
}