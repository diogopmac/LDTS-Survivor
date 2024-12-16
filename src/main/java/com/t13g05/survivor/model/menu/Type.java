package com.t13g05.survivor.model.menu;

public enum Type {
    START_GAME("Start Game"), OPTIONS("Options"),
    CONTROLS("Controls"), QUIT("Quit"),
    BACK("Back"), CLASS("Class"), WEAPON("Weapon"),
    WARRIOR("Warrior"), MAGE("Mage"),
    ROGUE("Rogue"), PALADIN("Paladin"), BOW("Bow"),
    PISTOL("Pistol"), SWORD("Sword");

    private final String text;

    Type(String text) {
        this.text = text;
    }
    public String getText() {
        return text;
    }
}
