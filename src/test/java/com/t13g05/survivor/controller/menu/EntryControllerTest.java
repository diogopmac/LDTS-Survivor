package com.t13g05.survivor.controller.menu;

import com.t13g05.survivor.Game;
import com.t13g05.survivor.GameConfig;
import com.t13g05.survivor.model.menu.ControlsMenu;
import com.t13g05.survivor.model.menu.MainMenu;
import com.t13g05.survivor.state.ControlsMenuState;
import com.t13g05.survivor.state.GameState;
import com.t13g05.survivor.state.MainMenuState;
import com.t13g05.survivor.state.OptionsMenuState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Set;

public class EntryControllerTest {
    private Game game;
    private EntryController entryController;
    private GameConfig gameConfig;
    private MainMenu mainMenu;

    @BeforeEach
    public void setUp() {
        game = Mockito.mock(Game.class);
        mainMenu = new MainMenu();
        entryController = new EntryController(mainMenu);

        gameConfig = GameConfig.getInstance();
        gameConfig.setSelectedClass("Warrior");
        gameConfig.setSelectedWeapon("Sword");
    }

    @Test
    public void selectStartGameTest(){
        entryController.step(game, Set.of(), System.currentTimeMillis());
        Mockito.verify(game).setState(Mockito.any(GameState.class));
    }

    @Test
    public void selectOptionsMenuTest(){
        mainMenu.moveDown();
        entryController.step(game, Set.of(), System.currentTimeMillis());
        Mockito.verify(game).setState(Mockito.any(OptionsMenuState.class));
    }

    @Test
    public void selectControlsMenuTest(){
        mainMenu.moveDown();
        mainMenu.moveDown();
        entryController.step(game, Set.of(), System.currentTimeMillis());
        Mockito.verify(game).setState(Mockito.any(ControlsMenuState.class));
    }

    @Test
    public void selectQuitTest(){
        mainMenu.moveUp();
        entryController.step(game, Set.of(), System.currentTimeMillis());
        Mockito.verify(game).setState(null);
    }

    @Test
    public void selectBackTest(){
        ControlsMenu controlsMenu = new ControlsMenu();
        EntryController entryController2 = new EntryController(controlsMenu);
        entryController2.step(game, Set.of(), System.currentTimeMillis());
        Mockito.verify(game).setState(Mockito.any(MainMenuState.class));
    }
}
