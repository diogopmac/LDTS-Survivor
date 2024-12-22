package com.t13g05.survivor.model.menu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class SettingsMenuTest {
    private SettingsMenu settingsMenu;
    private List<Entry> entries;
    private SettingsEntry settingsEntry;

    @BeforeEach
    public void setUp() {
        settingsMenu = new SettingsMenu();
        entries = settingsMenu.createEntries();
    }

    @Test
    public void entriesTest(){
        Assertions.assertNotNull(entries);
        Assertions.assertEquals(3, entries.size());

        Assertions.assertEquals(Type.CLASS, entries.get(0).getType());
        Assertions.assertInstanceOf(SettingsEntry.class, entries.get(0));
        settingsEntry = (SettingsEntry) entries.get(0);
        Assertions.assertEquals(
                Arrays.asList(Type.WARRIOR, Type.MAGE, Type.ROGUE),
                settingsEntry.getOptions());

        Assertions.assertEquals(Type.WEAPON, entries.get(1).getType());
        Assertions.assertInstanceOf(SettingsEntry.class, entries.get(1));
        settingsEntry = (SettingsEntry) entries.get(1);
        Assertions.assertEquals(Arrays.asList(Type.BOW, Type.PISTOL, Type.SWORD),
                settingsEntry.getOptions());

        Assertions.assertEquals(Type.BACK, entries.get(2).getType());
    }

    @Test
    public void getSelectedEntryTest(){
        Assertions.assertInstanceOf(SettingsEntry.class, settingsMenu.getEntry());
        settingsEntry = (SettingsEntry) settingsMenu.getEntry();
        Assertions.assertEquals(Type.WARRIOR, settingsEntry.getSelectedOption());

        Assertions.assertEquals(Type.WARRIOR, settingsMenu.getSelectedOption(Type.CLASS));
        Assertions.assertEquals(Type.BOW, settingsMenu.getSelectedOption(Type.WEAPON));

        settingsMenu.moveDown();

        Assertions.assertInstanceOf(SettingsEntry.class, settingsMenu.getEntry());
        settingsEntry = (SettingsEntry) settingsMenu.getEntry();
        Assertions.assertEquals(Type.BOW, settingsEntry.getSelectedOption());

        settingsMenu.moveDown();
        Assertions.assertFalse(settingsMenu.getEntry() instanceof SettingsEntry);
        Assertions.assertEquals(Type.BACK, settingsMenu.getEntry().getType());
    }

    @Test
    public void moveRightTest(){
        Assertions.assertInstanceOf(SettingsEntry.class, settingsMenu.getEntry());
        settingsEntry = (SettingsEntry) settingsMenu.getEntry();
        Assertions.assertEquals(Type.CLASS, settingsMenu.getEntry().getType());
        Assertions.assertEquals(Type.WARRIOR, settingsEntry.getSelectedOption());

        settingsMenu.moveRight();
        Assertions.assertEquals(Type.MAGE, settingsEntry.getSelectedOption());
        settingsMenu.moveRight();
        Assertions.assertEquals(Type.ROGUE, settingsEntry.getSelectedOption());
        settingsMenu.moveRight();
        Assertions.assertEquals(Type.WARRIOR, settingsEntry.getSelectedOption());

        settingsMenu.moveDown();
        settingsEntry = (SettingsEntry) settingsMenu.getEntry();
        Assertions.assertEquals(Type.BOW, settingsEntry.getSelectedOption());
        settingsMenu.moveRight();
        Assertions.assertEquals(Type.PISTOL, settingsEntry.getSelectedOption());
        settingsMenu.moveRight();
        Assertions.assertEquals(Type.SWORD, settingsEntry.getSelectedOption());
        settingsMenu.moveRight();
        Assertions.assertEquals(Type.BOW, settingsEntry.getSelectedOption());
    }

    @Test
    public void moveLeftTest(){
        Assertions.assertInstanceOf(SettingsEntry.class, settingsMenu.getEntry());
        settingsEntry = (SettingsEntry) settingsMenu.getEntry();
        Assertions.assertEquals(Type.CLASS, settingsMenu.getEntry().getType());
        Assertions.assertEquals(Type.WARRIOR, settingsEntry.getSelectedOption());

        settingsMenu.moveLeft();
        Assertions.assertEquals(Type.ROGUE, settingsEntry.getSelectedOption());
        settingsMenu.moveLeft();
        Assertions.assertEquals(Type.MAGE, settingsEntry.getSelectedOption());
        settingsMenu.moveLeft();
        Assertions.assertEquals(Type.WARRIOR, settingsEntry.getSelectedOption());

        settingsMenu.moveDown();
        settingsEntry = (SettingsEntry) settingsMenu.getEntry();
        Assertions.assertEquals(Type.BOW, settingsEntry.getSelectedOption());
        settingsMenu.moveRight();
        Assertions.assertEquals(Type.PISTOL, settingsEntry.getSelectedOption());
        settingsMenu.moveRight();
        Assertions.assertEquals(Type.SWORD, settingsEntry.getSelectedOption());
        settingsMenu.moveRight();
        Assertions.assertEquals(Type.BOW, settingsEntry.getSelectedOption());
    }
}
