package com.t13g05.survivor.model.game.arena;

import com.t13g05.survivor.gui.LanternaGUI;
import com.t13g05.survivor.model.Position;
import com.t13g05.survivor.model.game.element.entity.Monster;
import com.t13g05.survivor.model.game.element.entity.Survivor;

import java.util.List;

public class Arena {
    private int width;
    private int height;
    private Survivor survivor;
    private List<Monster> monsters;

    public Arena(int width, int height) {
        this.width = width;
        this.height = height;
        survivor = new Survivor(new Position(width/2, height/2));
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void draw(LanternaGUI gui) {
        survivor.draw(gui);
    }

    public Survivor getSurvivor() {
        return survivor;
    }
}
