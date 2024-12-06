package com.t13g05.survivor.controller;

import com.t13g05.survivor.Game;
import com.t13g05.survivor.gui.Action;
import com.t13g05.survivor.gui.GUI;

import java.util.Set;

public abstract class Controller<T> {
    private final T model;
    public Controller(T model) {
        this.model = model;
    }
    public T getModel() {
        return model;
    }

    public abstract void step(Game game, Set<Action> actions, long time);
}
