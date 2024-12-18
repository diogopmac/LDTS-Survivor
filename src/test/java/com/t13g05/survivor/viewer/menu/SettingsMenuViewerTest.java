package com.t13g05.survivor.viewer.menu;

import com.t13g05.survivor.Game;
import com.t13g05.survivor.gui.GUI;
import com.t13g05.survivor.model.menu.SettingsMenu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class SettingsMenuViewerTest {
    private SettingsMenuViewer viewer;
    private SettingsMenu settingsMenu;
    private GUI gui;
    private Game game;

    @BeforeEach
    public void setUp() {
        game = Mockito.mock(Game.class);
        gui = Mockito.mock(GUI.class);
        settingsMenu = new SettingsMenu();
        viewer = new SettingsMenuViewer(settingsMenu);
    }

    @Test
    public void drawTextTest() throws Exception {
        viewer.drawElements(gui);

        Mockito.verify(gui, Mockito.times(1)).drawText(
                Game.width / 2 - 8, Game.height / 10, "Settings ", "#FFFFFF");
        Mockito.verify(gui, Mockito.times(1)).drawText(
                Game.width / 2 - 12, Game.height / 3, "Class ", "#FFFFFF");
        Mockito.verify(gui, Mockito.times(1)).drawText(
                Game.width / 2 - 12, Game.height / 3+5, "Weapon ", "#FFFFFF");
    }

    @Test
    public void drawEntriesTest() throws Exception {
        viewer.drawElements(gui);

        Mockito.verify(gui, Mockito.times(1)).drawText(Game.width / 2 - 1, Game.height / 3, "Warrior", "#FFFF00");
        Mockito.verify(gui, Mockito.times(1)).drawText(Game.width / 2 - 1, Game.height / 3 + 5, "Sword", "#FFFFFF");

    }

    @Test
    public void refreshAndClearTest() throws Exception {
        viewer.drawElements(gui);
        Mockito.verify(gui, Mockito.times(1)).refresh();
        Mockito.verify(gui, Mockito.times(1)).clear();
    }
}
