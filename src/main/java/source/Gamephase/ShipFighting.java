package source;

// in the shipFighting phase
// invoke the shipFighting prompt class and shipFighting ask class
// execute the print method of them
class ShipFighting implements GamePhase{
    Prompt prompt;
    Ask ask;

    @Override
    public void printPrompt(Player x) {
        prompt = new shipFighting_prompt();
        prompt.print(x);
    }

    @Override
    public void askUser(Player x){
        ask = new shipFighting_ask();
        ask.print(x);
    }

    @Override
    public GamePhase updateToShipSetting() {
        return new ShipSetting();
    }

    @Override
    public GamePhase updateToShipFighting(){
        return new ShipFighting();
    }

}