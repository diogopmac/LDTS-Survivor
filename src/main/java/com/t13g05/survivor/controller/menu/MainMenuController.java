package com.t13g05.survivor.controller.menu;

import com.t13g05.survivor.Game;
import com.t13g05.survivor.model.menu.MainMenu;

public class MainMenuController extends MenuController<MainMenu> {
    public MainMenuController(MainMenu mainMenu, EntryController entryController) {
        super(mainMenu, entryController);
    }

    @Override
    protected void quitGame(Game game){
        game.setState(null);
    }
}
