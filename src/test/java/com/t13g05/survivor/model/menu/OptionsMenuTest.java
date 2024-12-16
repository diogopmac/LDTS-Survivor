package com.t13g05.survivor.model.menu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class OptionsMenuTest {
    private OptionsMenu optionsMenu;
    private List<Entry> entries;
    private OptionsEntry optionsEntry;

    @BeforeEach
    public void setUp() {
        optionsMenu = new OptionsMenu();
        entries = optionsMenu.getEntries();
    }

    @Test
    public void entriesTest(){
        Assertions.assertNotNull(entries);
        Assertions.assertEquals(3, entries.size());

        Assertions.assertEquals(Type.CLASS, entries.get(0).getType());
        Assertions.assertInstanceOf(OptionsEntry.class, entries.get(0));
        optionsEntry = (OptionsEntry) entries.get(0);
        Assertions.assertEquals(
                Arrays.asList(Type.WARRIOR, Type.MAGE,
                        Type.PALADIN, Type.ROGUE),
                optionsEntry.getOptions());

        Assertions.assertEquals(Type.WEAPON, entries.get(1).getType());
        Assertions.assertInstanceOf(OptionsEntry.class, entries.get(1));
        optionsEntry = (OptionsEntry) entries.get(1);
        Assertions.assertEquals(Arrays.asList(Type.SWORD, Type.PISTOL, Type.BOW),
                optionsEntry.getOptions());

        Assertions.assertEquals(Type.BACK, entries.get(2).getType());
    }

    @Test
    public void getSelectedEntryTest(){
        Assertions.assertInstanceOf(OptionsEntry.class, optionsMenu.getEntry());
        optionsEntry = (OptionsEntry) optionsMenu.getEntry();
        Assertions.assertEquals(Type.WARRIOR, optionsEntry.getSelectedOption());

        Assertions.assertEquals(Type.WARRIOR, optionsMenu.getSelectedOption(Type.CLASS));
        Assertions.assertEquals(Type.SWORD, optionsMenu.getSelectedOption(Type.WEAPON));

        optionsMenu.moveDown();

        Assertions.assertInstanceOf(OptionsEntry.class, optionsMenu.getEntry());
        optionsEntry = (OptionsEntry) optionsMenu.getEntry();
        Assertions.assertEquals(Type.SWORD, optionsEntry.getSelectedOption());

        optionsMenu.moveDown();
        Assertions.assertFalse(optionsMenu.getEntry() instanceof OptionsEntry);
        Assertions.assertEquals(Type.BACK, optionsMenu.getEntry().getType());
    }

    @Test
    public void moveRightTest(){
        Assertions.assertInstanceOf(OptionsEntry.class, optionsMenu.getEntry());
        optionsEntry = (OptionsEntry) optionsMenu.getEntry();
        Assertions.assertEquals(Type.CLASS, optionsMenu.getEntry().getType());
        Assertions.assertEquals(Type.WARRIOR, optionsEntry.getSelectedOption());

        optionsMenu.moveRight();
        Assertions.assertEquals(Type.MAGE, optionsEntry.getSelectedOption());
        optionsMenu.moveRight();
        Assertions.assertEquals(Type.PALADIN, optionsEntry.getSelectedOption());
        optionsMenu.moveRight();
        Assertions.assertEquals(Type.ROGUE, optionsEntry.getSelectedOption());
        optionsMenu.moveRight();
        Assertions.assertEquals(Type.WARRIOR, optionsEntry.getSelectedOption());

        optionsMenu.moveDown();
        optionsEntry = (OptionsEntry) optionsMenu.getEntry();
        Assertions.assertEquals(Type.SWORD, optionsEntry.getSelectedOption());
        optionsMenu.moveRight();
        Assertions.assertEquals(Type.PISTOL, optionsEntry.getSelectedOption());
        optionsMenu.moveRight();
        Assertions.assertEquals(Type.BOW, optionsEntry.getSelectedOption());
        optionsMenu.moveRight();
        Assertions.assertEquals(Type.SWORD, optionsEntry.getSelectedOption());
    }

    @Test
    public void moveLeftTest(){
        Assertions.assertInstanceOf(OptionsEntry.class, optionsMenu.getEntry());
        optionsEntry = (OptionsEntry) optionsMenu.getEntry();
        Assertions.assertEquals(Type.CLASS, optionsMenu.getEntry().getType());
        Assertions.assertEquals(Type.WARRIOR, optionsEntry.getSelectedOption());

        optionsMenu.moveLeft();
        Assertions.assertEquals(Type.ROGUE, optionsEntry.getSelectedOption());
        optionsMenu.moveLeft();
        Assertions.assertEquals(Type.PALADIN, optionsEntry.getSelectedOption());
        optionsMenu.moveLeft();
        Assertions.assertEquals(Type.MAGE, optionsEntry.getSelectedOption());
        optionsMenu.moveLeft();
        Assertions.assertEquals(Type.WARRIOR, optionsEntry.getSelectedOption());

        optionsMenu.moveDown();
        optionsEntry = (OptionsEntry) optionsMenu.getEntry();
        Assertions.assertEquals(Type.SWORD, optionsEntry.getSelectedOption());
        optionsMenu.moveRight();
        Assertions.assertEquals(Type.PISTOL, optionsEntry.getSelectedOption());
        optionsMenu.moveRight();
        Assertions.assertEquals(Type.BOW, optionsEntry.getSelectedOption());
        optionsMenu.moveRight();
        Assertions.assertEquals(Type.SWORD, optionsEntry.getSelectedOption());
    }
}
