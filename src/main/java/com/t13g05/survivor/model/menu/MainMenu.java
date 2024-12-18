package com.t13g05.survivor.model.menu;

import java.util.Arrays;
import java.util.List;
import com.t13g05.survivor.Game;
import com.t13g05.survivor.model.Position;

public class MainMenu extends Menu {
    public MainMenu() {
        super();
    }

    @Override
    public List<Entry> createEntries() {
        Entry start = new Entry(new Position((Game.width-10)/2, Game.height/3), Type.START_GAME);
        Entry settings = new Entry(new Position((Game.width-8)/2, Game.height/3+5), Type.OPTIONS);
        Entry controls = new Entry(new Position((Game.width-8)/2, Game.height/3+10), Type.CONTROLS);
        Entry exit = new Entry(new Position((Game.width-4)/2, Game.height/3+15), Type.QUIT);
        return Arrays.asList(start, settings, controls, exit);
    }
}
