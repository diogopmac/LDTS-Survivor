package com.t13g05.survivor.state;

import com.t13g05.survivor.model.menu.MainMenu;
import com.t13g05.survivor.viewer.Viewer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MainMenuStateTest {
    private MainMenuState mainMenuState;
    private MainMenu mainMenu;

    @BeforeEach
    public void setUp() {
        mainMenu = Mockito.mock(MainMenu.class);
        mainMenuState = new MainMenuState(mainMenu);
    }

    @Test
    public void testLevelUpMenu() {
        Assertions.assertNotNull(mainMenuState);

        Assertions.assertNotNull(mainMenuState.getViewer());
        Assertions.assertNotNull(mainMenuState.getController());
        Assertions.assertNotNull(mainMenuState.getModel());
    }
}
