package com.t13g05.survivor.controller.menu;

import com.t13g05.survivor.Game;
import com.t13g05.survivor.GameConfig;
import com.t13g05.survivor.gui.Action;
import com.t13g05.survivor.model.menu.SettingsMenu;
import com.t13g05.survivor.model.menu.Type;

import java.util.Set;

public class OptionsMenuController extends MenuController<SettingsMenu> {
    public OptionsMenuController(SettingsMenu settingsMenu, EntryController entryController) {
        super(settingsMenu, entryController);
    }

    @Override
    public void step(Game game, Set<Action> actions, long time) {
        super.step(game, actions, time);

        GameConfig config = GameConfig.getInstance();
        config.setSelectedClass(getModel().getSelectedOption(Type.CLASS).getText());
        config.setSelectedWeapon(getModel().getSelectedOption(Type.WEAPON).getText());
    }
}
