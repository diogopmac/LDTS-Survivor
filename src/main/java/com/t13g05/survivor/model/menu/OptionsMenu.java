package com.t13g05.survivor.model.menu;

import com.t13g05.survivor.Game;
import com.t13g05.survivor.model.Position;

import java.util.Arrays;
import java.util.List;

public class OptionsMenu extends Menu {
    public OptionsMenu() {
        super();
    }

    @Override
    public List<Entry> createEntries() {
        OptionsEntry classEntry = new OptionsEntry(new Position(Game.width/2-6, Game.height/3),
                Type.CLASS, Arrays.asList(Type.WARRIOR, Type.MAGE, Type.PALADIN, Type.ROGUE));
        OptionsEntry weaponEntry = new OptionsEntry(new Position(Game.width/2-6, Game.height/3+5),
                Type.WEAPON, Arrays.asList(Type.SWORD, Type.PISTOL, Type.BOW));
        Entry back = new Entry(new Position(Game.width/2-6, Game.height-10), Type.BACK);
        return Arrays.asList(classEntry, weaponEntry, back);
    }
}
