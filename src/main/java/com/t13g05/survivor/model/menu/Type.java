package com.t13g05.survivor.model.menu;

public enum Type {
    START_GAME("Start Game"), OPTIONS("Options"),
    CONTROLS("Controls"), QUIT("Quit"),
    BACK("Back"),
    CLASS("Class"),
    WARRIOR("Warrior"), MAGE("Mage"), ROGUE("Rogue"), PALADIN("Paladin"),
    WEAPON("Weapon"),
    BOW("Bow"), PISTOL("Pistol"), SWORD("Sword"),
    HP_UP("Upgrade Health"), FR_UP("Upgrade Fire Rate"), DMG_UP("Upgrade Damage");

    private final String text;

    Type(String text) {
        this.text = text;
    }
    public String getText() {
        return text;
    }
}
