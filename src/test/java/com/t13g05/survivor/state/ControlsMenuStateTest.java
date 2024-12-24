package com.t13g05.survivor.state;

import com.t13g05.survivor.model.game.arena.Arena;
import com.t13g05.survivor.model.menu.ControlsMenu;
import com.t13g05.survivor.viewer.Viewer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ControlsMenuStateTest {
    private ControlsMenuState controlsMenuState;
    private ControlsMenu controlsMenu;

    @BeforeEach
    public void setUp() {
        controlsMenu = Mockito.mock(ControlsMenu.class);
        controlsMenuState = new ControlsMenuState(controlsMenu);
    }

    @Test
    public void testControlsMenuState() {
        Assertions.assertNotNull(controlsMenuState);

        Assertions.assertNotNull(controlsMenuState.getViewer());
        Assertions.assertNotNull(controlsMenuState.getController());
        Assertions.assertNotNull(controlsMenuState.getModel());
    }
}
