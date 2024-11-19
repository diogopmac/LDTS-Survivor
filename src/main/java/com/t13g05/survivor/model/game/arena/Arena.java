package com.t13g05.survivor.model.game.arena;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.t13g05.survivor.gui.LanternaGUI;
import com.t13g05.survivor.model.Position;
import com.t13g05.survivor.model.game.entity.Survivor;

public class Arena {
    private int width;
    private int height;
    private Survivor survivor;

    public Arena(int width, int height) {
        this.width = width;
        this.height = height;
        survivor = new Survivor(new Position(width/2, height/2));
    }

    public void draw(LanternaGUI gui) {
        survivor.draw(gui);
    }
}
