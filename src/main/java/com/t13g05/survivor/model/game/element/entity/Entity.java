package com.t13g05.survivor.model.game.element.entity;

import com.t13g05.survivor.model.Position;

public class Entity {
    protected Position position;
    protected int health;
    
    protected Entity() {
        position = new Position(0,0);
        health = 0;
    }

    public Entity(Position position) {
        this.position = position;
    }

    public Position getPosition() { return position; }
    public void setPosition(Position position) { this.position = position; }
}
