package com.t13g05.survivor.model.menu;

public enum Type {
    START_GAME("Start Game"), OPTIONS("Options"),
    CONTROLS("Controls"), QUIT("Quit"),
    BACK("Back"),
    CLASS("Class"),
    WARRIOR("Warrior"), MAGE("Mage"), ROGUE("Rogue"), PALADIN("Paladin"),
    WEAPON("Weapon"),
    BOW("Bow"), PISTOL("Pistol"), SWORD("Sword"),
    HP_UP("Health"), FR_UP("Fire Rate"), DMG_UP("Damage");

    private final String text;

    Type(String text) {
        this.text = text;
    }
    public String getText() {
        return text;
    }
}
