package com.t13g05.survivor.model.game.element.entity;

import com.t13g05.survivor.model.Position;
import com.t13g05.survivor.model.game.element.Element;

public class Entity extends Element {
    protected int health;
    
    protected Entity() {
        super(new Position(0,0));
        health = 0;
    }
    
    public Entity(Position position) {
        super(position);
        this.health = 100;
    }

    public int getHealth() {
        return health;
    }
}
