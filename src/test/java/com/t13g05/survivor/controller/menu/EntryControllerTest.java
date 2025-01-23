package com.t13g05.survivor.controller.menu;

import com.t13g05.survivor.Game;
import com.t13g05.survivor.GameConfig;
import com.t13g05.survivor.model.game.arena.Arena;
import com.t13g05.survivor.model.menu.PauseMenu;
import com.t13g05.survivor.state.GameState;
import com.t13g05.survivor.model.game.element.entity.Survivor;
import com.t13g05.survivor.model.menu.ControlsMenu;
import com.t13g05.survivor.model.menu.LevelUpMenu;
import com.t13g05.survivor.model.menu.MainMenu;
import com.t13g05.survivor.state.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
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
        gameConfig.setSelectedWeapon("Bow");
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
        Mockito.verify(game).setState(Mockito.any(SettingsMenuState.class));
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

    @Test
    public void selectHPTest() throws IOException, URISyntaxException, FontFormatException {
        game = new Game();
        Arena arena = Mockito.mock(Arena.class);
        Survivor survivor = Mockito.mock(Survivor.class);
        Mockito.when(arena.getSurvivor()).thenReturn(survivor);

        GameState gameState = new GameState(arena);
        game.setState(gameState);
        game.saveState();

        LevelUpMenu levelUpMenu = new LevelUpMenu();
        EntryController entryController2 = new EntryController(levelUpMenu);
        game.setState(new LevelUpMenuState(levelUpMenu));

        entryController2.step(game, Set.of(), System.currentTimeMillis());
        Mockito.verify(survivor).upHealth();
        Assertions.assertNotNull(gameState);
    }

    @Test
    public void selectDMGTest() throws IOException, URISyntaxException, FontFormatException {
        game = new Game();
        Arena arena = Mockito.mock(Arena.class);
        Survivor survivor = Mockito.mock(Survivor.class);
        Mockito.when(arena.getSurvivor()).thenReturn(survivor);

        GameState gameState = new GameState(arena);
        game.setState(gameState);
        game.saveState();

        LevelUpMenu levelUpMenu = new LevelUpMenu();
        EntryController entryController2 = new EntryController(levelUpMenu);
        game.setState(new LevelUpMenuState(levelUpMenu));

        levelUpMenu.moveDown();

        entryController2.step(game, Set.of(), System.currentTimeMillis());
        Mockito.verify(survivor).upDamage();
        Assertions.assertNotNull(gameState);
    }

    @Test
    public void selectFRTest() throws IOException, URISyntaxException, FontFormatException {
        game = new Game();
        Arena arena = Mockito.mock(Arena.class);
        Survivor survivor = Mockito.mock(Survivor.class);
        Mockito.when(arena.getSurvivor()).thenReturn(survivor);

        GameState gameState = new GameState(arena);
        game.setState(gameState);
        game.saveState();

        LevelUpMenu levelUpMenu = new LevelUpMenu();
        EntryController entryController2 = new EntryController(levelUpMenu);
        game.setState(new LevelUpMenuState(levelUpMenu));

        levelUpMenu.moveDown();
        levelUpMenu.moveDown();

        entryController2.step(game, Set.of(), System.currentTimeMillis());
        Mockito.verify(survivor).upFireRate();
        Assertions.assertNotNull(gameState);
    }

    @Test
    public void resumeTest() throws IOException, URISyntaxException, FontFormatException {
        game = new Game();
        Arena arena = Mockito.mock(Arena.class);
        Survivor survivor = Mockito.mock(Survivor.class);
        Mockito.when(arena.getSurvivor()).thenReturn(survivor);

        GameState gameState = new GameState(arena);
        game.setState(gameState);

        GameState gameMock = (GameState) game.getState();

        game.saveState();

        PauseMenu pauseMenu = new PauseMenu();
        EntryController entryController2 = new EntryController(pauseMenu);
        game.setState(new PauseMenuState(pauseMenu));

        Assertions.assertTrue(pauseMenu.isSelected(0));
        entryController2.step(game, Set.of(), System.currentTimeMillis());

        Assertions.assertEquals(gameMock, game.getState());
    }
}
