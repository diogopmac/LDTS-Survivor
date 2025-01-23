package com.t13g05.survivor.model.menu;

import com.t13g05.survivor.Game;
import com.t13g05.survivor.model.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MainMenuTest {
    private MainMenu mainMenu;
    private List<Entry> entries;

    @BeforeEach
    public void setUp() {
        mainMenu = new MainMenu();
        entries = mainMenu.createEntries();
    }

    @Test
    public void entriesTest() {
        Assertions.assertNotNull(entries);
        Assertions.assertFalse(entries.isEmpty());

        Assertions.assertEquals(Type.START_GAME, entries.get(0).getType());
        Assertions.assertEquals(Type.OPTIONS, entries.get(1).getType());
        Assertions.assertEquals(Type.CONTROLS, entries.get(2).getType());
        Assertions.assertEquals(Type.QUIT, entries.get(3).getType());

        Assertions.assertEquals(new Position((Game.width-10)/2, Game.height/3), entries.get(0).getPosition());
        Assertions.assertEquals(new Position((Game.width-8)/2, Game.height/3+5), entries.get(1).getPosition());
        Assertions.assertEquals(new Position((Game.width-8)/2, Game.height/3+10), entries.get(2).getPosition());
        Assertions.assertEquals(new Position((Game.width-4)/2, Game.height/3+15), entries.get(3).getPosition());

        Assertions.assertEquals(Type.START_GAME.getText(), "Start Game");
        Assertions.assertEquals(Type.OPTIONS.getText(), "Settings");
        Assertions.assertEquals(Type.CONTROLS.getText(), "Controls");
        Assertions.assertEquals(Type.QUIT.getText(), "Quit");
    }

    @Test
    public void moveDownTest() {
        Assertions.assertTrue(mainMenu.isSelected(0));

        mainMenu.moveDown();
        Assertions.assertFalse(mainMenu.isSelected(0));
        Assertions.assertTrue(mainMenu.isSelected(1));

        mainMenu.moveDown();
        Assertions.assertFalse(mainMenu.isSelected(1));
        Assertions.assertTrue(mainMenu.isSelected(2));

        mainMenu.moveDown();
        Assertions.assertFalse(mainMenu.isSelected(2));
        Assertions.assertTrue(mainMenu.isSelected(3));

        mainMenu.moveDown();
        Assertions.assertFalse(mainMenu.isSelected(3));
        Assertions.assertTrue(mainMenu.isSelected(0));
    }

    @Test
    public void moveUpTest() {
        Assertions.assertTrue(mainMenu.isSelected(0));

        mainMenu.moveUp();
        Assertions.assertFalse(mainMenu.isSelected(0));
        Assertions.assertTrue(mainMenu.isSelected(3));

        mainMenu.moveUp();
        Assertions.assertFalse(mainMenu.isSelected(3));
        Assertions.assertTrue(mainMenu.isSelected(2));

        mainMenu.moveUp();
        Assertions.assertFalse(mainMenu.isSelected(2));
        Assertions.assertTrue(mainMenu.isSelected(1));

        mainMenu.moveUp();
        Assertions.assertFalse(mainMenu.isSelected(1));
        Assertions.assertTrue(mainMenu.isSelected(0));

    }

    @Test
    public void gettersTest() {
        Assertions.assertEquals(mainMenu.getEntryCount(), 4);
        Assertions.assertEquals(mainMenu.getEntries().size(), 4);
    }
}
