package com.t13g05.survivor.model.menu;

import com.t13g05.survivor.Game;
import com.t13g05.survivor.model.Position;

import java.util.Arrays;
import java.util.List;

public class SettingsMenu extends Menu {
    public SettingsMenu() {
        super();
    }

    public Type getSelectedOption(Type type) {
        for (Entry entry : entries) {
            if (entry instanceof SettingsEntry settingsEntry && settingsEntry.getType() == type) {
                return settingsEntry.getSelectedOption();
            }
        }
        return null;
    }

    @Override
    public List<Entry> createEntries() {
        SettingsEntry classEntry = new SettingsEntry(new Position(Game.width/2+2, Game.height/3),
                Type.CLASS, Arrays.asList(Type.WARRIOR, Type.MAGE, Type.ROGUE));
        SettingsEntry weaponEntry = new SettingsEntry(new Position(Game.width/2+2, Game.height/3+5),
                Type.WEAPON, Arrays.asList(Type.BOW, Type.PISTOL, Type.SWORD));
        Entry back = new Entry(new Position((Game.width-5)/2, Game.height-10), Type.BACK);
        return Arrays.asList(classEntry, weaponEntry, back);
    }
}
