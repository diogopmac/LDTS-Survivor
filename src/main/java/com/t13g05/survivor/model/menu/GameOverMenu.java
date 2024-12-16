package com.t13g05.survivor.model.menu;

import com.t13g05.survivor.Game;
import com.t13g05.survivor.model.Position;

import java.util.Arrays;
import java.util.List;

public class GameOverMenu extends Menu {
    public GameOverMenu() {
        super();
    }
    @Override
    public List<Entry> createEntries(){
        Entry retry = new Entry(new Position(Game.width/2-6, Game.height/3), Type.START_GAME);
        Entry back = new Entry(new Position(Game.width/2-6, Game.height/3+5), Type.BACK);
        return Arrays.asList(retry, back);
    }
}
