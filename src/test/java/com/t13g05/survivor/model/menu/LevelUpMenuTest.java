package com.t13g05.survivor.model.menu;

import com.t13g05.survivor.Game;
import com.t13g05.survivor.model.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LevelUpMenuTest {
    private LevelUpMenu levelUpMenu;
    private int width = Game.width;
    private int height = Game.height;
    private List<Entry> entries;

    @BeforeEach
    public void setUp() {
        levelUpMenu = new LevelUpMenu();
        entries = levelUpMenu.createEntries();
    }

    @Test
    public void entriesTest(){
        Assertions.assertNotNull(entries);
        Assertions.assertEquals(entries.size(), 3);

        Assertions.assertEquals(Type.HP_UP, entries.get(0).getType());
        Assertions.assertEquals(Type.DMG_UP, entries.get(1).getType());
        Assertions.assertEquals(Type.FR_UP, entries.get(2).getType());

        Assertions.assertEquals(new Position((width-6)/4, height/2), entries.get(0).getPosition());
        Assertions.assertEquals(new Position((width-6)/2, height/2), entries.get(1).getPosition());
        Assertions.assertEquals(new Position((width-9)*3/4, height/2), entries.get(2).getPosition());
    }
}
