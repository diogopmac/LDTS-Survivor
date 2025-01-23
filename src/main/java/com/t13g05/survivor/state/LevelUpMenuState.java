package com.t13g05.survivor.state;

import com.t13g05.survivor.controller.Controller;
import com.t13g05.survivor.controller.menu.EntryController;
import com.t13g05.survivor.controller.menu.LevelUpMenuController;
import com.t13g05.survivor.model.menu.LevelUpMenu;
import com.t13g05.survivor.viewer.Viewer;
import com.t13g05.survivor.viewer.menu.LevelUpMenuViewer;

public class LevelUpMenuState extends State<LevelUpMenu> {
    public LevelUpMenuState(LevelUpMenu levelUpMenu) {
        super(levelUpMenu);
    }

    @Override
    protected Viewer<LevelUpMenu> getViewer() {
        return new LevelUpMenuViewer(getModel());
    }

    @Override
    protected Controller<LevelUpMenu> getController() {
        return new LevelUpMenuController(getModel(), new EntryController(getModel()));
    }

}
