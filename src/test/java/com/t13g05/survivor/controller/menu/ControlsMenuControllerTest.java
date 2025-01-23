package com.t13g05.survivor.controller.menu;

import com.t13g05.survivor.Game;
import com.t13g05.survivor.gui.Action;
import com.t13g05.survivor.model.menu.ControlsMenu;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.LinkedHashSet;
import java.util.Set;

public class ControlsMenuControllerTest {
    private Game game;
    private ControlsMenuController controlsMenuController;
    private ControlsMenu controlsMenu;
    private EntryController entryController;

    @BeforeEach
    public void setUp() {
        game = Mockito.mock(Game.class);
        entryController = Mockito.mock(EntryController.class);
        controlsMenu = new ControlsMenu();
        controlsMenuController = new ControlsMenuController(controlsMenu, entryController);
    }

    @Test
    public void moveTest(){
        Assertions.assertTrue(controlsMenu.isSelected(0));

        Set<Action> actions = new LinkedHashSet<>();
        actions.add(Action.UP);
        entryController.step(game, actions, System.currentTimeMillis());
        Assertions.assertTrue(controlsMenu.isSelected(0));
    }

    @Test
    public void selectTest(){
        Assertions.assertTrue(controlsMenu.isSelected(0));
        Set<Action> actions = new LinkedHashSet<>();
        actions.add(Action.SELECT);
        controlsMenuController.step(game, actions, System.currentTimeMillis());

        Mockito.verify(entryController).step(Mockito.any(Game.class), Mockito.anySet(), Mockito.anyLong());
    }
}
