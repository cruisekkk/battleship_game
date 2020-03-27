package source;

// Prompt is an interface class
// There are three sub phases class can implement Prompt
// start_prompt, shipSetting_prompt, shipFighting_prompt
// They have the similar behavior as they need those three methods

interface Prompt {
    // print the proper prompt (usually, display the map)before the asking part
    void print(Player x);
}