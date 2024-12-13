package com.t13g05.survivor.controller.menu;

import com.t13g05.survivor.Game;
import com.t13g05.survivor.model.menu.ControlsMenu;
import com.t13g05.survivor.model.menu.MainMenu;
import com.t13g05.survivor.state.MainMenuState;

public class ControlsMenuController extends MenuController<ControlsMenu> {
    public ControlsMenuController(ControlsMenu controlsMenu, EntryController entryController) {
        super(controlsMenu, entryController);
    }

    @Override
    protected void quitGame(Game game){
        game.setState(new MainMenuState(new MainMenu()));
    }
}
