package com.t13g05.survivor.viewer.menu;

import com.t13g05.survivor.Game;
import com.t13g05.survivor.gui.GUI;
import com.t13g05.survivor.model.menu.GameOverMenu;
import com.t13g05.survivor.model.menu.LevelUpMenu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class LevelUpMenuViewerTest {
    private GUI gui;
    private LevelUpMenuViewer viewer;
    private LevelUpMenu levelUpMenu;
    private Game game;

    @BeforeEach
    public void setUp() {
        game = Mockito.mock(Game.class);
        gui = Mockito.mock(GUI.class);
        levelUpMenu = new LevelUpMenu();
        viewer = new LevelUpMenuViewer(levelUpMenu);
    }

    @Test
    public void testInit() throws Exception {
        viewer.drawElements(gui);
        Mockito.verify(gui, Mockito.times(1)).drawText(((Game.width-8))/2, Game.height/10, "Level Up", "#FFFFFF");
        Mockito.verify(gui, Mockito.times(1)).drawText((Game.width-6)/4, (Game.height/2), "Health", "#FFFF00");
        Mockito.verify(gui, Mockito.times(1)).drawText((Game.width-6)/2, (Game.height/2), "Damage", "#FFFFFF");
        Mockito.verify(gui, Mockito.times(1)).drawText((Game.width-9)*3/4, (Game.height/2), "Fire Rate", "#FFFFFF");

    }
}
