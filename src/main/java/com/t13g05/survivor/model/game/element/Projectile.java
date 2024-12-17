package com.t13g05.survivor.model.game.element;

import com.t13g05.survivor.model.Position;
import com.t13g05.survivor.model.weapon.Weapon;

public class Projectile extends Element {
    Position position;
    Position direction;
    int distanceTraveled;
    Weapon weapon;

    public Projectile(Position position, Position direction, Weapon weapon) {
        this.position = new Position(position.x() + direction.x(), position.y() + direction.y());
        this.direction = direction;
        distanceTraveled = 0;
        this.weapon = weapon;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        if (distanceTraveled <= weapon.getRange()) {
            this.position = position;
            distanceTraveled++;
        }
    }

    public Position getDirection() {
        return direction;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public int getDistanceTraveled() {
        return distanceTraveled;
    }
}
