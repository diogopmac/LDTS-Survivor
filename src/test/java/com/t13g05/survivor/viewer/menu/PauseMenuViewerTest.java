package com.t13g05.survivor.viewer.menu;

import com.t13g05.survivor.Game;
import com.t13g05.survivor.gui.GUI;
import com.t13g05.survivor.model.menu.PauseMenu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class PauseMenuViewerTest {
    private PauseMenuViewer viewer;
    private GUI gui;
    private PauseMenu pauseMenu;
    private Game game;

    @BeforeEach
    public void setUp() {
        game = Mockito.mock(Game.class);
        gui = Mockito.mock(GUI.class);
        pauseMenu = new PauseMenu();
        viewer = new PauseMenuViewer(pauseMenu);
    }

    @Test
    public void testInit() throws Exception {
        viewer.drawElements(gui);
        Mockito.verify(gui).drawText((Game.width-6)/2,Game.height/10, "Paused", "#FFFFFF");
        Mockito.verify(gui).drawText((Game.width-6)/2, Game.height/3, "Resume", "#FFFF00");
        Mockito.verify(gui).drawText((Game.width-4)/2, Game.height/3+5, "Back", "#FFFFFF");

    }

}
