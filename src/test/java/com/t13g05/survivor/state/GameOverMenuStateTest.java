package com.t13g05.survivor.state;

import com.t13g05.survivor.model.game.arena.Arena;
import com.t13g05.survivor.model.menu.GameOverMenu;
import com.t13g05.survivor.viewer.Viewer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class GameOverMenuStateTest {
    GameOverMenuState gameOverMenuState;
    GameOverMenu gameOverMenu;

    @BeforeEach
    public void setUp() {
        gameOverMenu = Mockito.mock(GameOverMenu.class);
        gameOverMenuState = new GameOverMenuState(gameOverMenu);
    }

    @Test
    public void testGameOverMenuState() {
        Assertions.assertNotNull(gameOverMenuState);

        Assertions.assertNotNull(gameOverMenuState.getViewer());
        Assertions.assertNotNull(gameOverMenuState.getController());
        Assertions.assertNotNull(gameOverMenuState.getModel());
    }
}
