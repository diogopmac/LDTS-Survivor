package com.t13g05.survivor.controller.menu;

import com.t13g05.survivor.Game;
import com.t13g05.survivor.controller.Controller;
import com.t13g05.survivor.gui.Action;
import com.t13g05.survivor.model.menu.Menu;

import java.util.Set;

public abstract class MenuController<T extends Menu> extends Controller<T> {
    private final EntryController entryController;
    public MenuController(T entry, EntryController entryController) {
        super(entry);
        this.entryController = entryController;
    }

    @Override
    public void step(Game game, Set<Action> actions, long time) {
        for (Action action : actions) {
            switch (action) {
                case UP:
                    getModel().moveUp();
                    break;
                case DOWN:
                    getModel().moveDown();
                    break;
                case QUIT:
                    quitGame(game);
                    break;
                default:
                    entryController.step(game, actions, time);
            }
        }

    }

    protected abstract void quitGame(Game game);
}
