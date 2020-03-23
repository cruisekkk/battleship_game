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

    }

    @Override
    public GamePhase updateToShipSetting() {
        return new ShipSetting();
    }

}