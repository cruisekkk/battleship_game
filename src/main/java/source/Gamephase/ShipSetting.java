package source;

class ShipSetting implements GamePhase {
    Prompt prompt;
    Ask ask;

    @Override
    public void printPrompt(Player x) {
        prompt = new shipSetting_prompt();
        prompt.print(x);
    }

    @Override
    public void askUser(Player x){
        ask = new shipSetting_ask();
        ask.print(x);
    }

    @Override
    public GamePhase updateToShipSetting() {
        return new ShipSetting();
    }

}