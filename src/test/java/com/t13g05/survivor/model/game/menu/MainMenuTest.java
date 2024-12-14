package com.t13g05.survivor.model.game.menu;

import com.t13g05.survivor.model.menu.Entry;
import com.t13g05.survivor.model.menu.MainMenu;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MainMenuTest {
    private MainMenu mainMenu;

    @BeforeEach
    public void setUp() throws Exception {
        mainMenu = new MainMenu();
    }
    @Test
    public void createEntriesTest() {
        mainMenu.createEntries();
        List<Entry> entries = mainMenu.getEntries();

        Assertions.assertNotNull(entries);
        for (Entry entry : entries) {
            Assertions.assertNotNull(entry);
        }
    }
}
