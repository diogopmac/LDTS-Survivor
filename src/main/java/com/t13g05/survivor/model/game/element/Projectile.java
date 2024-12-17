package com.t13g05.survivor.model.game.element;

import com.t13g05.survivor.model.Position;

public class Projectile extends Element {
    int type;
    Position position;
    Position direction;

    public Projectile(Position position, Position direction, int type) {
        this.position = new Position(position.x() + direction.x(), position.y() + direction.y());
        this.direction = direction;
        this.type = type;
    }

    public Position getPosition() {
        return position;
    }
}
