package source;
//package source.Gamephase;

// in the start phase
// invoke the start prompt class and start ask class
// execute the print method of them
class Start implements GamePhase{
    Prompt prompt;
    Ask ask;

    @Override
    public void printPrompt(Player x) {
        prompt = new start_prompt();
        prompt.print(x);
    }

    @Override
    public void askUser(Player x) {
        ask = new start_ask();
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