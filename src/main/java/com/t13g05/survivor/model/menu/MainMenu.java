package com.t13g05.survivor.model.menu;

import java.util.Arrays;
import java.util.List;
import com.t13g05.survivor.Game;
import com.t13g05.survivor.model.Position;

public class MainMenu extends Menu {
    @Override
    public List<Entry> createEntries() {
        Entry start = new Entry(new Position(Game.widht, Game.height), Type.START_GAME);
        Entry settings = new Entry(new Position(Game.widht, Game.height), Type.OPTIONS);
        Entry controls = new Entry(new Position(Game.widht, Game.height), Type.CONTROLS);
        Entry exit = new Entry(new Position(Game.widht, Game.height), Type.QUIT);
        return Arrays.asList(start, settings, controls, exit);
    }
}
