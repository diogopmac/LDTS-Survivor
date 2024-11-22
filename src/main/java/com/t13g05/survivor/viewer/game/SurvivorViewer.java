package com.t13g05.survivor.viewer.game;

import com.t13g05.survivor.gui.GUI;
import com.t13g05.survivor.model.game.element.entity.Survivor;

public class SurvivorViewer implements ElementViewer<Survivor> {
    @Override
    public void draw(Survivor survivor, GUI gui) {
        gui.drawSurvivor(survivor.getPosition());
    }
}