package com.t13g05.survivor.viewer.menu;

import com.t13g05.survivor.Game;
import com.t13g05.survivor.gui.GUI;
import com.t13g05.survivor.model.menu.ControlsMenu;
import com.t13g05.survivor.model.menu.GameOverMenu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class GameOverMenuViewerTest {
    private GUI gui;
    private GameOverMenuViewer viewer;
    private GameOverMenu gameOverMenu;
    private Game game;

    @BeforeEach
    public void setUp() {
        game = Mockito.mock(Game.class);
        gui = Mockito.mock(GUI.class);
        gameOverMenu = new GameOverMenu();
        viewer = new GameOverMenuViewer(gameOverMenu);
    }

    @Test
    public void entriesTest()throws Exception{
        viewer.drawElements(gui);
        Mockito.verify(gui, Mockito.times(1)).drawText((Game.width-9)/2, Game.height/10+3, "Game Over", "#FFFFFF");
        Mockito.verify(gui, Mockito.times(1)).drawText((Game.width-5)/2, Game.height/3+3, "Retry", "#FFFF00");
        Mockito.verify(gui, Mockito.times(1)).drawText((Game.width-17)/2, Game.height/3+8, "Back to Main Menu", "#FFFFFF");
    }
}
