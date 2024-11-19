package com.t13g05.survivor.model.game.entity;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.t13g05.survivor.gui.LanternaGUI;
import com.t13g05.survivor.model.Position;

public class Survivor {
    protected Position position;

    public Survivor(Position position) {
        this.position = position;
    }

    public void draw(LanternaGUI gui) {
        gui.drawSurvivor(position);
    }
}
