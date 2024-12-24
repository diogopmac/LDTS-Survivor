package com.t13g05.survivor.state;

import com.t13g05.survivor.model.game.arena.Arena;
import com.t13g05.survivor.model.menu.LevelUpMenu;
import com.t13g05.survivor.viewer.Viewer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class LevelUpMenuStateTest {
    private LevelUpMenuState levelUpMenuState;
    private LevelUpMenu levelUpMenu;

    @BeforeEach
    public void setUp() {
        levelUpMenu = Mockito.mock(LevelUpMenu.class);
        levelUpMenuState = new LevelUpMenuState(levelUpMenu);
    }

    @Test
    public void testLevelUpMenu() {
        Assertions.assertNotNull(levelUpMenuState);

        Assertions.assertNotNull(levelUpMenuState.getViewer());
        Assertions.assertNotNull(levelUpMenuState.getController());
        Assertions.assertNotNull(levelUpMenuState.getModel());
    }
}
