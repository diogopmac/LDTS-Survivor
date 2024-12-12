package com.t13g05.survivor.viewer.screens;

import com.t13g05.survivor.gui.GUI;
import com.t13g05.survivor.model.Position;
import com.t13g05.survivor.model.game.arena.Arena;
import com.t13g05.survivor.model.game.element.Element;
import com.t13g05.survivor.model.game.element.entity.Monster;
import com.t13g05.survivor.viewer.Viewer;
import com.t13g05.survivor.viewer.game.ElementViewer;
import com.t13g05.survivor.viewer.game.MonsterViewer;
import com.t13g05.survivor.viewer.game.SurvivorViewer;

import java.io.IOException;
import java.util.List;
import java.util.Random;

public class GameViewer extends Viewer<Arena> {
    public GameViewer(Arena arena) {
        super(arena);
    }

    @Override
    public void drawElements(GUI gui) throws IOException {
        //Extremely temporary function for demonstration purpose only
        //Will be removed when proper MonsterController is implemented
        Random rnd = new Random();
        for (Monster monster : getModel().getMonsters()) {
            monster.setPosition(new Position(
                    monster.getPosition().x() + rnd.nextInt(3)-1,
                    monster.getPosition().y() + rnd.nextInt(3)-1
            ));
        }

        drawElement(gui, getModel().getSurvivor(), new SurvivorViewer());
        drawElements(gui, getModel().getMonsters(), new MonsterViewer());


        gui.drawText(0, getModel().getHeight()-1, getModel().getSurvivor().getHealth() + "HP", "#ff5445");
    }

    private <T extends Element> void drawElements(GUI gui, List<T> elements, ElementViewer<T> viewer) {
        for (T element : elements)
            drawElement(gui, element, viewer);
    }

    private <T extends Element> void drawElement(GUI gui, T element, ElementViewer<T> viewer) {
        viewer.draw(element, gui);
    }
}
