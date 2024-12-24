package com.t13g05.survivor.controller.menu;

import com.t13g05.survivor.Game;
import com.t13g05.survivor.GameConfig;
import com.t13g05.survivor.gui.Action;
import com.t13g05.survivor.model.menu.SettingsMenu;
import com.t13g05.survivor.model.menu.Type;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.LinkedHashSet;
import java.util.Set;

public class SettingsMenuControllerTest {
    private Game game;
    private SettingsMenu settingsMenu;
    private EntryController entryController;
    private OptionsMenuController optionsMenuController;

    @BeforeEach
    public void setUp() {
        game = Mockito.mock(Game.class);
        entryController = Mockito.mock(EntryController.class);
        settingsMenu = new SettingsMenu();
        optionsMenuController = new OptionsMenuController(settingsMenu, entryController);

        GameConfig.getInstance().setSelectedClass("Warrior");
        GameConfig.getInstance().setSelectedWeapon("Sword");
    }

    @Test
    public void moveTest(){
        Assertions.assertTrue(settingsMenu.isSelected(0));

        Set<Action> actions = new LinkedHashSet<>();
        actions.add(Action.DOWN);
        optionsMenuController.step(game, actions, System.currentTimeMillis());
        Assertions.assertTrue(settingsMenu.isSelected(1));

        actions.clear();
        actions.add(Action.UP);
        optionsMenuController.step(game, actions, System.currentTimeMillis());
        Assertions.assertTrue(settingsMenu.isSelected(0));
    }

    @Test
    public void moveHorizontallyTest(){
        Assertions.assertTrue(settingsMenu.isSelected(0));
        Set<Action> actions = new LinkedHashSet<>();
        actions.add(Action.RIGHT);
        optionsMenuController.step(game, actions, System.currentTimeMillis());
        Assertions.assertEquals(Type.MAGE.getText(), GameConfig.getInstance().getSelectedClass());

        actions.clear();
        actions.add(Action.LEFT);
        optionsMenuController.step(game, actions, System.currentTimeMillis());
        actions.clear();
        actions.add(Action.LEFT);
        optionsMenuController.step(game, actions, System.currentTimeMillis());
        Assertions.assertEquals(Type.ROGUE.getText(), GameConfig.getInstance().getSelectedClass());

        actions.clear();
        actions.add(Action.DOWN);
        optionsMenuController.step(game, actions, System.currentTimeMillis());
        Assertions.assertEquals(Type.ROGUE.getText(), GameConfig.getInstance().getSelectedClass());
        Assertions.assertTrue(settingsMenu.isSelected(1));
        Assertions.assertEquals(Type.BOW.getText(), GameConfig.getInstance().getSelectedWeapon());
    }
}
