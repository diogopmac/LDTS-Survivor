package com.t13g05.survivor.controller.menu;

import com.t13g05.survivor.Game;
import com.t13g05.survivor.gui.Action;
import com.t13g05.survivor.model.menu.GameOverMenu;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.LinkedHashSet;
import java.util.Set;

public class GameOverMenuControllerTest {
    private Game game;
    private GameOverMenuController gameOverMenuController;
    private GameOverMenu gameOverMenu;
    private EntryController entryController;

    @BeforeEach
    public void setUp() {
        game = Mockito.mock(Game.class);
        entryController = Mockito.mock(EntryController.class);
        gameOverMenu = new GameOverMenu();
        gameOverMenuController = new GameOverMenuController(gameOverMenu, entryController);
    }

    @Test
    public void moveTest(){
        Assertions.assertTrue(gameOverMenu.isSelected(0));

        Set<Action> actions = new LinkedHashSet<>();
        actions.add(Action.DOWN);
        gameOverMenuController.step(game, actions, System.currentTimeMillis());
        Assertions.assertTrue(gameOverMenu.isSelected(1));
    }

    @Test
    public void selectTest(){
        Assertions.assertTrue(gameOverMenu.isSelected(0));
        Set<Action> actions = new LinkedHashSet<>();
        actions.add(Action.SELECT);
        gameOverMenuController.step(game, actions, System.currentTimeMillis());

        Mockito.verify(entryController).step(Mockito.any(Game.class), Mockito.anySet(), Mockito.anyLong());
    }
}
