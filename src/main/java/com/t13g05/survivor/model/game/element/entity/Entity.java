package com.t13g05.survivor.model.game.element.entity;

import com.t13g05.survivor.model.Position;
import com.t13g05.survivor.model.game.element.Element;

public class Entity extends Element {
    protected int health;
    protected int damage;

    protected Entity() {
        super(new Position(0,0));
        health = 0;
        damage = 0;
    }
    
    public Entity(Position position, int health) {
        super(position);
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public void damage(int damageDealt) {
        health = Math.max(health - damageDealt, 0);
    }

    public int getDamage() {
        return damage;
    }
}
