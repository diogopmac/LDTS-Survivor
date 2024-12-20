package com.t13g05.survivor.model.menu;

import com.t13g05.survivor.Game;
import com.t13g05.survivor.model.Position;

import java.util.Arrays;
import java.util.List;

public class LevelUpMenu extends Menu {
    public LevelUpMenu() {
        super();
    }
    @Override
    public List<Entry> createEntries(){
        Entry hp = new Entry(new Position((Game.width-6)/4, (Game.height/2)), Type.HP_UP);
        Entry dmg = new Entry(new Position((Game.width-6)/2, (Game.height/2)), Type.DMG_UP);
        Entry fr = new Entry(new Position((Game.width-9)*3/4, (Game.height/2)), Type.FR_UP);
        return Arrays.asList(hp, dmg, fr);
    }
}
