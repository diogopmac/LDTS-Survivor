package com.t13g05.survivor.state;

import com.t13g05.survivor.model.menu.LevelUpMenu;
import com.t13g05.survivor.model.menu.SettingsMenu;
import com.t13g05.survivor.viewer.Viewer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class SettingsMenuStateTest {
    private SettingsMenuState settingsMenuState;
    private SettingsMenu settingsMenu;

    @BeforeEach
    public void setUp() {
        settingsMenu = Mockito.mock(SettingsMenu.class);
        settingsMenuState = new SettingsMenuState(settingsMenu);
    }

    @Test
    public void testLevelUpMenu() {
        Assertions.assertNotNull(settingsMenuState);
        Assertions.assertNotNull(settingsMenuState.getViewer());
        Assertions.assertNotNull(settingsMenuState.getController());
        Assertions.assertNotNull(settingsMenuState.getModel());
    }
}
