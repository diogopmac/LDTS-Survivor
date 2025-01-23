package com.t13g05.survivor.controller.menu;

import com.t13g05.survivor.Game;
import com.t13g05.survivor.gui.Action;
import com.t13g05.survivor.model.menu.LevelUpMenu;

import java.util.Set;

public class LevelUpMenuController extends MenuController<LevelUpMenu> {
    public LevelUpMenuController(LevelUpMenu levelUpMenu, EntryController entryController) {
        super(levelUpMenu, entryController);
    }

    @Override
    public void step(Game game, Set<Action> actions, long time) {
        // For loop only runs once to prevent crashes due to changing the ActionSet
        // This does not affect the usability of the menu
        for (Action action : actions) {
            switch (action) {
                case RIGHT:
                    this.getModel().moveDown();
                    actions.remove(Action.RIGHT);
                    break;

                case LEFT:
                    this.getModel().moveUp();
                    actions.remove(Action.LEFT);
                    break;

                case SELECT:
                    entryController.step(game, actions, time);
                    actions.remove(Action.SELECT);
                    break;
            }
            break;
        }
    }
}
