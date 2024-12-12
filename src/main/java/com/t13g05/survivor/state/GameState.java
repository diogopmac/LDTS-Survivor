package com.t13g05.survivor.state;

import com.t13g05.survivor.controller.Controller;
import com.t13g05.survivor.model.game.arena.Arena;
import com.t13g05.survivor.viewer.Viewer;
import com.t13g05.survivor.viewer.menu.EntryViewer;
import com.t13g05.survivor.viewer.screens.GameViewer;

public class GameState extends State<Arena> {
    public GameState(Arena arena) {
        super(arena);
    }

    @Override
    protected Viewer<Arena> getViewer() {
        return new GameViewer(getModel());
    }

    @Override
    protected Controller<Arena> getController() {
        // TODO
       //return new ArenaController(getModel());
        return null;
    }
}
