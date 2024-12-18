package com.t13g05.survivor.model.game.element.entity;

import com.t13g05.survivor.gui.LanternaGUI;
import com.t13g05.survivor.model.Position;
import com.t13g05.survivor.model.weapon.Weapon;

public class Survivor extends Entity {
    Weapon weapon;
    Position direction = new Position(1, 0);

    public Survivor(Position position, int health, String weapon) {
        super(position, health);
        try {
            this.weapon = (Weapon) Class.forName("com.t13g05.survivor.model.weapon." + weapon).newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println(this.weapon);
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public Position getDirection() {
        return direction;
    }

    public void setDirection(Position direction) {
        this.direction = direction;
    }
}
