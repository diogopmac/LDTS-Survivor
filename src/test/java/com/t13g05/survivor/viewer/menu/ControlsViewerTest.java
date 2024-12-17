package com.t13g05.survivor.viewer.menu;

import com.t13g05.survivor.Game;
import com.t13g05.survivor.gui.GUI;
import com.t13g05.survivor.model.menu.ControlsMenu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

public class ControlsViewerTest {
    private GUI gui;
    private ControlsMenuViewer viewer;
    private ControlsMenu controlsMenu;
    private Game game;

    @BeforeEach
    public void setUp() {
        game = Mockito.mock(Game.class);
        gui = Mockito.mock(GUI.class);
        controlsMenu = new ControlsMenu();
        viewer = new ControlsMenuViewer(controlsMenu);
    }

    @Test
    public void drawEntriesTest() throws Exception {
        viewer.drawElements(gui);

        Mockito.verify(gui, Mockito.times(1)).drawText(Game.width/2-6,Game.height/10, "Controls", "#FFFFFF");

        Mockito.verify(gui, Mockito.times(1)).drawText(Game.width / 2 - 6, Game.height - 10,
                "Back", "#FFFF00");
    }

    @Test
    public void drawControls() throws Exception {
        viewer.drawElements(gui);

        Mockito.verify(gui, Mockito.times(1)).drawText(Game.width / 2 - 10, Game.height / 4 + 0, "Move UP", "#FFFFFF");
        Mockito.verify(gui, Mockito.times(1)).drawText(Game.width / 2 + 4, Game.height / 4 + 0, "W", "#FFFFFF");

        Mockito.verify(gui, Mockito.times(1)).drawText(Game.width / 2 - 10, Game.height / 4 + 2, "Move DOWN", "#FFFFFF");
        Mockito.verify(gui, Mockito.times(1)).drawText(Game.width / 2 + 4, Game.height / 4 + 2, "S", "#FFFFFF");

        Mockito.verify(gui, Mockito.times(1)).drawText(Game.width / 2 - 10, Game.height / 4 + 4, "Move Right", "#FFFFFF");
        Mockito.verify(gui, Mockito.times(1)).drawText(Game.width / 2 + 4, Game.height / 4 + 4, "D", "#FFFFFF");

        Mockito.verify(gui, Mockito.times(1)).drawText(Game.width / 2 - 10, Game.height / 4 + 6, "Move LEFT", "#FFFFFF");
        Mockito.verify(gui, Mockito.times(1)).drawText(Game.width / 2 + 4, Game.height / 4 + 6, "A", "#FFFFFF");

        Mockito.verify(gui, Mockito.times(1)).drawText(Game.width / 2 - 10, Game.height / 4 + 8, "Shoot", "#FFFFFF");
        Mockito.verify(gui, Mockito.times(1)).drawText(Game.width / 2 + 4, Game.height / 4 + 8, "P", "#FFFFFF");

        Mockito.verify(gui, Mockito.times(1)).drawText(Game.width / 2 - 10, Game.height / 4 + 10, "Ability 1", "#FFFFFF");
        Mockito.verify(gui, Mockito.times(1)).drawText(Game.width / 2 + 4, Game.height / 4 + 10, "O", "#FFFFFF");

        Mockito.verify(gui, Mockito.times(1)).drawText(Game.width / 2 - 10, Game.height / 4 + 12, "Ability 2", "#FFFFFF");
        Mockito.verify(gui, Mockito.times(1)).drawText(Game.width / 2 + 4, Game.height / 4 + 12, "U", "#FFFFFF");

    }

    @Test
    public void refreshAndClearTest() throws Exception {
        viewer.drawElements(gui);
        Mockito.verify(gui, Mockito.times(1)).refresh();
        Mockito.verify(gui, Mockito.times(1)).clear();
    }


}
