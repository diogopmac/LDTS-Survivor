package com.t13g05.survivor.controller.menu;

import com.t13g05.survivor.Game;
import com.t13g05.survivor.controller.Controller;
import com.t13g05.survivor.gui.Action;
import com.t13g05.survivor.model.menu.Menu;

public abstract class MenuController<T extends Menu> extends Controller<T> {
    private final EntryController entryController;
    public MenuController(T entry, EntryController entryController) {
        super(entry);
        this.entryController = entryController;
    }

    @Override
    public void step(Game game, Action action, long time) {
        switch (action) {
            case UP:
                this.getModel().moveUp();
                break;
            case DOWN:
                this.getModel().moveDown();
                break;
            case QUIT:
                // sai do jogo
            default:
                entryController.step(game, action, time);
        }
    }
}
