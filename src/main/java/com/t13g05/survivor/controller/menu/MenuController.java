package com.t13g05.survivor.controller.menu;

import com.t13g05.survivor.Game;
import com.t13g05.survivor.controller.Controller;
import com.t13g05.survivor.gui.Action;
import com.t13g05.survivor.model.menu.Menu;
import com.t13g05.survivor.model.menu.OptionsEntry;

import java.util.Set;

public abstract class MenuController<T extends Menu> extends Controller<T> {
    protected final EntryController entryController;

    public MenuController(T menu, EntryController entryController) {
        super(menu);
        this.entryController = entryController;
    }

    @Override
    public void step(Game game, Set<Action> actions, long time) {
        for (Action action : actions) {
            switch (action) {
                case UP:
                    this.getModel().moveUp();
                    actions.remove(Action.UP);
                    break;
                case DOWN:
                    this.getModel().moveDown();
                    actions.remove(Action.DOWN);
                    break;
                case RIGHT:
                    getModel().moveRight();
                    actions.remove(Action.RIGHT);
                    break;
                case LEFT:
                    getModel().moveLeft();
                    actions.remove(Action.LEFT);
                    break;
                case SELECT:
                    entryController.step(game, actions, time);
                    actions.remove(Action.SELECT);
            }
        }

    }
}
