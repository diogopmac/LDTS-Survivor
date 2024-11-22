package com.t13g05.survivor.state;

import com.t13g05.survivor.model.game.arena.Arena;
import com.t13g05.survivor.viewer.Viewer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class GameStateTest {
    private GameState gameState;
    private Arena arena;

    @BeforeEach
    void setUp() {
        arena = Mockito.mock(Arena.class);
    }

    @Test
    public void testGameState() {
        GameState gameState = new GameState(arena);
        Assertions.assertNotNull(gameState);

        Viewer<Arena> viewer = gameState.getViewer();
        Assertions.assertNotNull(viewer);

        Assertions.assertNotNull(gameState.getModel());
    }
}
