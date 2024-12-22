package com.t13g05.survivor.controller.menu;

import com.t13g05.survivor.Game;
import com.t13g05.survivor.gui.Action;
import com.t13g05.survivor.model.menu.LevelUpMenu;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.LinkedHashSet;
import java.util.Set;

public class LevelUpMenuControllerTest {
    private Game game;
    private LevelUpMenuController levelUpMenuController;
    private LevelUpMenu levelUpMenu;
    private EntryController entryController;

    @BeforeEach
    public void setUp() {
        game = Mockito.mock(Game.class);
        entryController = Mockito.mock(EntryController.class);
        levelUpMenu = new LevelUpMenu();
        levelUpMenuController = new LevelUpMenuController(levelUpMenu, entryController);
    }

    @Test
    public void moveTest(){
        Assertions.assertTrue(levelUpMenu.isSelected(0));

        Set<Action> actions = new LinkedHashSet<>();
        actions.add(Action.RIGHT);
        levelUpMenuController.step(game, actions, System.currentTimeMillis());
        Assertions.assertTrue(levelUpMenu.isSelected(1));

        actions.clear();
        actions.add(Action.LEFT);
        levelUpMenuController.step(game, actions, System.currentTimeMillis());
        Assertions.assertTrue(levelUpMenu.isSelected(0));
    }

    @Test
    public void selectEntryTest(){
        Assertions.assertTrue(levelUpMenu.isSelected(0));
        Set<Action> actions = new LinkedHashSet<>();
        actions.add(Action.SELECT);
        levelUpMenuController.step(game, actions, System.currentTimeMillis());

        Mockito.verify(entryController).step(Mockito.any(Game.class), Mockito.anySet(), Mockito.anyLong());
    }


}
