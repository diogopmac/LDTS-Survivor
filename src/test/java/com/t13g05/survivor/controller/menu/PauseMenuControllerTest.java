package com.t13g05.survivor.controller.menu;

import com.t13g05.survivor.Game;
import com.t13g05.survivor.gui.Action;
import com.t13g05.survivor.model.menu.PauseMenu;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.LinkedHashSet;
import java.util.Set;

public class PauseMenuControllerTest {
    private Game game;
    private PauseMenuController pauseMenuController;
    private PauseMenu pauseMenu;
    private EntryController entryController;

    @BeforeEach
    public void setUp() {
        game = Mockito.mock(Game.class);
        entryController = Mockito.mock(EntryController.class);
        pauseMenu = new PauseMenu();
        pauseMenuController = new PauseMenuController(pauseMenu, entryController);
    }

    @Test
    public void moveTest(){
        Assertions.assertTrue(pauseMenu.isSelected(0));

        Set<Action> actions = new LinkedHashSet<>();
        actions.add(Action.UP);
        pauseMenuController.step(game, actions, System.currentTimeMillis());
        Assertions.assertTrue(pauseMenu.isSelected(1));
    }

    @Test
    public void selectTest(){
        Assertions.assertTrue(pauseMenu.isSelected(0));
        Set<Action> actions = new LinkedHashSet<>();
        actions.add(Action.SELECT);
        pauseMenuController.step(game, actions, System.currentTimeMillis());

        Mockito.verify(entryController).step(Mockito.any(Game.class), Mockito.anySet(), Mockito.anyLong());
    }
}
