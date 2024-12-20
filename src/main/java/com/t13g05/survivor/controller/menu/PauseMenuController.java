package com.t13g05.survivor.controller.menu;

import com.t13g05.survivor.model.menu.Entry;
import com.t13g05.survivor.model.menu.PauseMenu;

public class PauseMenuController extends MenuController<PauseMenu> {
    public PauseMenuController(PauseMenu pauseMenu, EntryController entryController) {
        super(pauseMenu, entryController);
    }
}
