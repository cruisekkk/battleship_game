package source;

class shipSetting_prompt implements Prompt {
    @Override
    public void print(Player x){
        String n = "";
        n += x.displaySelf();
        n += "Player " + x.name;
        n += " you are going to place the following ships (which are all rectangular). For each\n";
        n += "ship, type the coordinate of the upper left side of the ship, followed by either H (for\n";
        n += "horizontal) or V (for vertical). For example M4H would place a ship horizontally starting\n";
        n += "at M4 and going to the right. You have\n";
        n += "\n";
        n += "2 \"Submarines\" ships that are 1x2\n";
        n += "3 \"Destroyers\" that are 1x3\n";
        n += "3 \"Battleships\" that are 1x4\n";
        n += "2 \"Carriers\" that are 1x6\n";
        System.out.println(n);
    }
}