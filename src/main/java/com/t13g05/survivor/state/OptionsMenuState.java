package com.t13g05.survivor.state;

import com.t13g05.survivor.controller.Controller;
import com.t13g05.survivor.controller.menu.EntryController;
import com.t13g05.survivor.controller.menu.OptionsMenuController;
import com.t13g05.survivor.model.menu.SettingsMenu;
import com.t13g05.survivor.viewer.Viewer;
import com.t13g05.survivor.viewer.menu.SettingsMenuViewer;

public class OptionsMenuState extends State<SettingsMenu> {
    public OptionsMenuState(SettingsMenu menu) {
        super(menu);
    }
    @Override
    protected Viewer<SettingsMenu> getViewer() {
        return new SettingsMenuViewer(getModel());
    }

    @Override
    protected Controller<SettingsMenu> getController() {
        return new OptionsMenuController(getModel(), new EntryController(getModel()));
    }
}

