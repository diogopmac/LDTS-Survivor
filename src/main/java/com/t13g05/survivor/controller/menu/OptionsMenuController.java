package com.t13g05.survivor.controller.menu;

import com.t13g05.survivor.Game;
import com.t13g05.survivor.GameConfig;
import com.t13g05.survivor.gui.Action;
import com.t13g05.survivor.model.menu.OptionsMenu;
import com.t13g05.survivor.model.menu.Type;

import java.util.Set;

public class OptionsMenuController extends MenuController<OptionsMenu> {
    public OptionsMenuController(OptionsMenu optionsMenu, EntryController entryController) {
        super(optionsMenu, entryController);
    }

    @Override
    public void step(Game game, Set<Action> actions, long time) {
        super.step(game, actions, time);

        GameConfig config = GameConfig.getInstance();
        config.setSelectedClass(getModel().getSelectedOption(Type.CLASS).getText());
        config.setSelectedWeapon(getModel().getSelectedOption(Type.WEAPON).getText());
    }
}
