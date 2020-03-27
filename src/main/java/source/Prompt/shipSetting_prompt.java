package source;

class shipSetting_prompt implements Prompt {
    @Override
    // the prompt in the shipSetting phase
    // in this phase, the prompt would be firstly display the current ocean of the player
    // then give some helpful information about how to set
    // It would invoke the displaySelf() function in the player
    // use the player's name
    public void print(Player x){
        String n = "Current Ocean:\n";
        n += x.displaySelf();
        n += "Player " + x.name;
        n += " you are going to place the following ships (which are rectangular or special shape). For each\n";
        n += "ship, type the coordinate of the upper left side of the ship. The direction for Submarine and \n";
        n += "Destroyer is either H (for horizontal) or V (for vertical). For example M4H would place a ship \n";
        n += "horizontally starting at M4 and going to the right. \n";
        n += "However, the direction for Battleship and Carrier is either U (for up), R (for right), D (for down),\n";
        n += "or L (left).\n";
        n += "You have\n";
        n += "\n";
        n += "2 \"Submarines\" ships that are 1x2 rectangles\n";
        n += "3 \"Destroyers\" that are 1x3 rectangles\n";
        n += "3 \"Battleships\" that are not rectangles, but take 4 blocks\n";
        n += "2 \"Carriers\" that are not rectangles, but take 6 blocks\n";
        System.out.println(n);
    }
}