package com.t13g05.survivor;

public class GameConfig {
    private static GameConfig instance;

    private String selectedClass;
    private String selectedWeapon;

    private GameConfig() {
        this.selectedClass = "Warrior";
        this.selectedWeapon = "Sword";
    }

    public static GameConfig getInstance() {
        if (instance == null) instance = new GameConfig();
        return instance;
    }

    public String getSelectedClass() { return selectedClass; }
    public void setSelectedClass(String selectedClass) { this.selectedClass = selectedClass; }

    public String getSelectedWeapon() { return selectedWeapon; }
    public void setSelectedWeapon(String selectedWeapon) { this.selectedWeapon = selectedWeapon; }
}
