package com.t13g05.survivor.state;

import com.t13g05.survivor.controller.Controller;
import com.t13g05.survivor.controller.menu.ControlsMenuController;
import com.t13g05.survivor.controller.menu.EntryController;
import com.t13g05.survivor.controller.menu.MainMenuController;
import com.t13g05.survivor.model.menu.ControlsMenu;
import com.t13g05.survivor.model.menu.MainMenu;
import com.t13g05.survivor.viewer.Viewer;
import com.t13g05.survivor.viewer.screens.ControlsMenuViewer;

public class ControlsMenuState extends State<ControlsMenu> {
    public ControlsMenuState(ControlsMenu menu) {
        super(menu);
    }

    @Override
    protected Viewer<ControlsMenu> getViewer() {
        return new ControlsMenuViewer(getModel());
    }

    @Override
    protected Controller<ControlsMenu> getController() {
        return new ControlsMenuController(getModel(), new EntryController(getModel()));
    }
}
