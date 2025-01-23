package com.t13g05.survivor.state;

import com.t13g05.survivor.controller.Controller;
import com.t13g05.survivor.controller.menu.EntryController;
import com.t13g05.survivor.controller.menu.PauseMenuController;
import com.t13g05.survivor.model.menu.PauseMenu;
import com.t13g05.survivor.viewer.Viewer;
import com.t13g05.survivor.viewer.menu.PauseMenuViewer;

public class PauseMenuState extends State<PauseMenu> {
    public PauseMenuState(PauseMenu pauseMenu) {
        super(pauseMenu);
    }

    @Override
    protected Viewer<PauseMenu> getViewer() {
        return new PauseMenuViewer(getModel());
    }

    @Override
    protected Controller<PauseMenu> getController() {
        return new PauseMenuController(getModel(), new EntryController(getModel()));
    }
}
