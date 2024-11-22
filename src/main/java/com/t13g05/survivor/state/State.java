package com.t13g05.survivor.state;

import com.t13g05.survivor.Game;
import com.t13g05.survivor.viewer.Viewer;
import com.t13g05.survivor.gui.GUI;

import java.io.IOException;

public abstract class State<T> {
    private final T model;
    //private final Controller<T> controller;
    private final Viewer<T> viewer;

    public State(T model) {
        this.model = model;
        this.viewer = getViewer();
        //this.controller = getController();
    }

    protected abstract Viewer<T> getViewer();

    //protected abstract Controller<T> getController();

    public T getModel() {
        return model;
    }

    public void step(Game game, GUI gui, long time) throws IOException {
        for(GUI.ACTION a : gui.getActions()) {
            System.out.println(a);
        }
        //controller.step(game, action, time);
        viewer.draw(gui);
    }
}