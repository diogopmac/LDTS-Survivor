package com.t13g05.survivor.model.menu;

import com.t13g05.survivor.Game;
import com.t13g05.survivor.model.Position;

import java.util.Arrays;
import java.util.List;

public class ControlsMenu extends Menu {
    public ControlsMenu() {
        super();
    }

    @Override
    public List<Entry> createEntries(){
        Entry back = new Entry(new Position(Game.widht/2-6, Game.height-10), Type.BACK);
        return Arrays.asList(back);
    }
}
