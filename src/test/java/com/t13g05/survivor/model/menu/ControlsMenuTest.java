package com.t13g05.survivor.model.menu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ControlsMenuTest {
    private ControlsMenu controlsMenu;
    private List<Entry> entries;

    @BeforeEach
    public void setUp() {
        controlsMenu = new ControlsMenu();
        entries = controlsMenu.getEntries();
    }

    @Test
    public void entriesTest(){
        Assertions.assertNotNull(entries);
        Assertions.assertEquals(1, entries.size());

        Assertions.assertEquals(Type.BACK, entries.get(0).getType());
    }

    @Test
    public void moveUpTest(){
        controlsMenu.moveUp();
        Assertions.assertTrue(controlsMenu.isSelected(0));
    }

    @Test
    public void moveDownTest(){
        controlsMenu.moveDown();
        Assertions.assertTrue(controlsMenu.isSelected(0));
    }
}
