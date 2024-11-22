package com.t13g05.survivor.model.game.element.entity;

import com.t13g05.survivor.gui.LanternaGUI;
import com.t13g05.survivor.model.Position;
import com.t13g05.survivor.model.weapon.Weapon;

public class Survivor extends Entity {
    Weapon weapon;

    public Survivor(Position position) {
        super(position);
    }

    public void draw(LanternaGUI gui) {
        gui.drawSurvivor(position);
    }
}
