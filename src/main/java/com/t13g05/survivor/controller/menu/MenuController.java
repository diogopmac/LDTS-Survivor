package com.t13g05.survivor.controller.menu;

import com.t13g05.survivor.Game;
import com.t13g05.survivor.controller.Controller;
import com.t13g05.survivor.gui.Action;
import com.t13g05.survivor.model.menu.Menu;

import java.util.Set;

public abstract class MenuController<T extends Menu> extends Controller<T> {
    private final EntryController entryController;

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
                case SELECT:
                    entryController.step(game, actions, time);
                    actions.remove(Action.SELECT);
                    break;
            }
        }

    }

    protected abstract void quitGame(Game game);
}
