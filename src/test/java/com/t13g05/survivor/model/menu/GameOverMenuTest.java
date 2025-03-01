package com.t13g05.survivor.model.menu;

import com.t13g05.survivor.Game;
import com.t13g05.survivor.model.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class GameOverMenuTest {
    private GameOverMenu gameOverMenu;
    private int width = Game.width;
    private int height = Game.height;
    private List<Entry> entries;

    @BeforeEach
    public void setUp() {
        gameOverMenu = new GameOverMenu();
        entries = gameOverMenu.createEntries();
    }

    @Test
    public void entriesTest(){
        Assertions.assertNotNull(entries);
        Assertions.assertEquals(entries.size(), 2);

        Assertions.assertEquals(Type.START_GAME, entries.get(0).getType());
        Assertions.assertEquals(Type.BACK, entries.get(1).getType());

        Assertions.assertEquals(new Position(width/2-6, height/3), entries.get(0).getPosition());
        Assertions.assertEquals(new Position(width/2-6, height/3+5), entries.get(1).getPosition());
    }
}
