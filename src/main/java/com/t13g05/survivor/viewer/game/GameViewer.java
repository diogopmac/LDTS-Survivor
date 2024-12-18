package com.t13g05.survivor.viewer.game;

import com.t13g05.survivor.gui.GUI;
import com.t13g05.survivor.model.game.arena.Arena;
import com.t13g05.survivor.model.game.element.Element;
import com.t13g05.survivor.viewer.Viewer;


import java.util.List;

public class GameViewer extends Viewer<Arena> {
    public GameViewer(Arena arena) {
        super(arena);
    }

    @Override
    public void drawElements(GUI gui) {
        drawElement(gui, getModel().getSurvivor(), new SurvivorViewer());
        drawElements(gui, getModel().getMonsters(), new MonsterViewer());
        drawElements(gui, getModel().getProjectiles(), new ProjectileViewer());


        gui.drawText(0, getModel().getHeight()-1, getModel().getSurvivor().getHealth() + "HP", "#ff5445");
        gui.drawText(0, 0, "Level: " + getModel().getSurvivor().getLevel() + " (" + getModel().getSurvivor().getExperience() + "/" + getModel().getSurvivor().necessaryExp() + ")", "#5c54eb");
    }

    private <T extends Element> void drawElements(GUI gui, List<T> elements, ElementViewer<T> viewer) {
        for (T element : elements)
            drawElement(gui, element, viewer);
    }

    private <T extends Element> void drawElement(GUI gui, T element, ElementViewer<T> viewer) {
        viewer.draw(element, gui);
    }
}
