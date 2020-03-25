package source;

class shipFighting_prompt implements Prompt {
    @Override
    public void print(Player x) {
        String n = "Player " + x.name + "'s turn:\n";
        n += "   Your ocean                                   Player " + x.enemyName + "'s ocean\n";
        n += x.displayAll();
        System.out.println(n);
    }
}