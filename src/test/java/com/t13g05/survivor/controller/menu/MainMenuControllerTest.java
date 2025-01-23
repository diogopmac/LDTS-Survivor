package com.t13g05.survivor.controller.menu;

import com.t13g05.survivor.Game;
import com.t13g05.survivor.gui.Action;
import com.t13g05.survivor.model.menu.MainMenu;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.LinkedHashSet;
import java.util.Set;

public class MainMenuControllerTest {
    private Game game;
    private MainMenu mainMenu;
    private EntryController entryController;
    private MainMenuController mainMenuController;

    @BeforeEach
    public void setUp() {
        game = Mockito.mock(Game.class);
        mainMenu = new MainMenu();
        entryController = Mockito.mock(EntryController.class);
        mainMenuController = new MainMenuController(mainMenu, entryController);
    }

    @Test
    public void moveTest(){
        Assertions.assertTrue(mainMenu.isSelected(0));

        Set<Action> actions = new LinkedHashSet<>();
        actions.add(Action.DOWN);
        mainMenuController.step(game, actions, System.currentTimeMillis());
        Assertions.assertTrue(mainMenu.isSelected(1));

        actions.clear();
        actions.add(Action.UP);
        mainMenuController.step(game, actions, System.currentTimeMillis());
        Assertions.assertTrue(mainMenu.isSelected(0));
    }

    @Test
    public void selectEntryTest(){
        Assertions.assertTrue(mainMenu.isSelected(0));
        Set<Action> actions = new LinkedHashSet<>();
        actions.add(Action.SELECT);
        mainMenuController.step(game, actions, System.currentTimeMillis());

        Mockito.verify(entryController).step(Mockito.any(Game.class), Mockito.anySet(), Mockito.anyLong());
    }

}
