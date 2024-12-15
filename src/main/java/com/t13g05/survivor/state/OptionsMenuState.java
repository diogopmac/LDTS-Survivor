package com.t13g05.survivor.state;

import com.t13g05.survivor.controller.Controller;
import com.t13g05.survivor.controller.menu.EntryController;
import com.t13g05.survivor.controller.menu.MainMenuController;
import com.t13g05.survivor.controller.menu.OptionsMenuController;
import com.t13g05.survivor.model.menu.ControlsMenu;
import com.t13g05.survivor.model.menu.MainMenu;
import com.t13g05.survivor.model.menu.OptionsMenu;
import com.t13g05.survivor.viewer.Viewer;
import com.t13g05.survivor.viewer.menu.ControlsMenuViewer;
import com.t13g05.survivor.viewer.menu.MainMenuViewer;
import com.t13g05.survivor.viewer.menu.OptionsMenuViewer;

public class OptionsMenuState extends State<OptionsMenu> {
    public OptionsMenuState(OptionsMenu menu) {
        super(menu);
    }
    @Override
    protected Viewer<OptionsMenu> getViewer() {
        return new OptionsMenuViewer(getModel());
    }

    @Override
    protected Controller<OptionsMenu> getController() {
        return new OptionsMenuController(getModel(), new EntryController(getModel()));
    }
}

