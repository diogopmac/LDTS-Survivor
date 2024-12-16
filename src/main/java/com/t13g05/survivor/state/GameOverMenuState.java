package com.t13g05.survivor.state;

import com.t13g05.survivor.controller.Controller;
import com.t13g05.survivor.controller.menu.EntryController;
import com.t13g05.survivor.controller.menu.GameOverMenuController;
import com.t13g05.survivor.controller.menu.MainMenuController;
import com.t13g05.survivor.model.game.arena.Arena;
import com.t13g05.survivor.model.menu.GameOverMenu;
import com.t13g05.survivor.model.menu.MainMenu;
import com.t13g05.survivor.viewer.Viewer;
import com.t13g05.survivor.viewer.menu.GameOverMenuViewer;

public class GameOverMenuState extends State<GameOverMenu> {
    public GameOverMenuState(GameOverMenu gameOverMenu) {
        super(gameOverMenu);
    }
    @Override
    protected Viewer<GameOverMenu> getViewer() {
        return new GameOverMenuViewer(getModel());
    }
    @Override
    protected Controller<GameOverMenu> getController() {
        return new GameOverMenuController(getModel(), new EntryController(getModel()));
    }
}
