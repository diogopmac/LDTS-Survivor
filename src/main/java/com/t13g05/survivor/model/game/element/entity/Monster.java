package com.t13g05.survivor.model.game.element.entity;

import com.t13g05.survivor.gui.LanternaGUI;
import com.t13g05.survivor.model.Position;

public class Monster extends Entity {
    private int damage = 10;

    public Monster(Position position) {super(position, 10);}

    public int getDamage() {
        return damage;
    }
}
