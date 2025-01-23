package com.t13g05.survivor.model.menu;

import com.t13g05.survivor.Game;
import com.t13g05.survivor.model.Position;

import java.util.Arrays;
import java.util.List;

public class PauseMenu extends Menu {
    public PauseMenu() {
        super();
    }

    @Override
    public List<Entry> createEntries(){
        Entry resume = new Entry(new Position((Game.width-6)/2, Game.height/3), Type.RESUME);
        Entry back = new Entry(new Position((Game.width-4)/2, Game.height/3+5), Type.BACK);

        return Arrays.asList(resume, back);
    }
}
