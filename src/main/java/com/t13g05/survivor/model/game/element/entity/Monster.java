package com.t13g05.survivor.model.game.element.entity;

import com.t13g05.survivor.model.Position;

public class Monster extends Entity {
    public Monster(Position position, int health, int damage) {
        super(position, health);
        this.damage = damage;
    }
}
