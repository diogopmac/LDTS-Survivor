package com.t13g05.survivor.viewer.menu;

import com.sun.tools.javac.Main;
import com.t13g05.survivor.Game;
import com.t13g05.survivor.gui.GUI;
import com.t13g05.survivor.model.Position;
import com.t13g05.survivor.model.menu.Entry;
import com.t13g05.survivor.model.menu.MainMenu;
import com.t13g05.survivor.model.menu.Type;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

public class MainMenuViewerTest {
    private GUI gui;
    private MainMenuViewer viewer;
    private MainMenu mainMenu;
    private Game game;
    List<Entry> entries;

    @BeforeEach
    public void setUp() {
        game = Mockito.mock(Game.class);
        gui = Mockito.mock(GUI.class);
        mainMenu = new MainMenu();
        viewer = new MainMenuViewer(mainMenu);
        entries = mainMenu.getEntries();
    }

    @Test
    public void drawEntriesTest() throws Exception {
        List<Entry> entries = mainMenu.getEntries();

        viewer.drawElements(gui);
        Mockito.verify(gui, Mockito.times(1)).drawText((Game.width-8)/2,Game.height/10, "Survivor", "#FFFFFF");

        Assertions.assertEquals(new Position((Game.width-10)/2, Game.height / 3), entries.get(0).getPosition());
        Assertions.assertEquals(Type.START_GAME, entries.get(0).getType());

        Assertions.assertEquals(new Position((Game.width-8)/2, Game.height / 3 + 5), entries.get(1).getPosition());
        Assertions.assertEquals(Type.OPTIONS, entries.get(1).getType());

        Assertions.assertEquals(new Position((Game.width-8)/2, Game.height / 3 + 10), entries.get(2).getPosition());
        Assertions.assertEquals(Type.CONTROLS, entries.get(2).getType());

        Assertions.assertEquals(new Position((Game.width-4)/2, Game.height / 3 + 15), entries.get(3).getPosition());
        Assertions.assertEquals(Type.QUIT, entries.get(3).getType());
    }

    @Test
    public void drawEntryTest2() throws Exception {
        viewer.drawElements(gui);

        Mockito.verify(gui, Mockito.times(1)).clear();
        Mockito.verify(gui, Mockito.times(1)).drawText((Game.width-8)/2, Game.height / 10, "Survivor", "#FFFFFF");

        Mockito.verify(gui, Mockito.times(1)).drawText((Game.width-10)/2, Game.height / 3, "Start Game", "#FFFF00");
        Mockito.verify(gui, Mockito.times(1)).drawText((Game.width-8)/2, Game.height / 3 + 5, "Settings", "#FFFFFF");
        Mockito.verify(gui, Mockito.times(1)).drawText((Game.width-8)/2, Game.height / 3 + 10, "Controls", "#FFFFFF");
        Mockito.verify(gui, Mockito.times(1)).drawText((Game.width-4)/2, Game.height / 3 + 15, "Quit", "#FFFFFF");

        Mockito.verify(gui, Mockito.times(1)).refresh();
    }

    @Test
    public void refreshAndClearTest() throws Exception {
        viewer.drawElements(gui);
        Mockito.verify(gui, Mockito.times(1)).refresh();
        Mockito.verify(gui, Mockito.times(1)).clear();
    }



}
