package com.t13g05.survivor.model.game.entity;

import com.t13g05.survivor.model.Position;

public class Entity {
    protected Position position;

    public Entity(int x, int y) {
        this.position = new Position(x, y);
    }

    public Position getPosition() { return position; }
    public void setPosition(Position position) { this.position = position; }
}
