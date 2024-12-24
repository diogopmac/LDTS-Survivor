package com.t13g05.survivor.state;

import com.t13g05.survivor.model.menu.LevelUpMenu;
import com.t13g05.survivor.model.menu.PauseMenu;
import com.t13g05.survivor.viewer.Viewer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class PauseMenuStateTest {
    PauseMenuState pauseMenuState;
    PauseMenu pauseMenu;

    @BeforeEach
    public void setUp() {
        pauseMenu = Mockito.mock(PauseMenu.class);
        pauseMenuState = new PauseMenuState(pauseMenu);
    }

    @Test
    public void testLevelUpMenu() {
        Assertions.assertNotNull(pauseMenuState);

        Assertions.assertNotNull(pauseMenuState.getViewer());
        Assertions.assertNotNull(pauseMenuState.getController());
        Assertions.assertNotNull(pauseMenuState.getModel());
    }
}
