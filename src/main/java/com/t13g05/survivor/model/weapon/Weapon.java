package com.t13g05.survivor.model.weapon;

import com.t13g05.survivor.model.Position;
import com.t13g05.survivor.model.game.element.Projectile;

public abstract class Weapon {
    int delay;
    int baseDamage;
    int projectileType;
    int range;

    protected Weapon(int delay, int base_damage, int projectile_type, int range) {
        this.delay = delay;
        this.baseDamage = base_damage;
        this.projectileType = projectile_type;
        this.range = range;
    }

    public Weapon(String weaponType) {
        switch (weaponType) {
            case "Bow" -> new Bow();
            case "Sword" -> new Sword();
            case "Pistol" -> new Pistol();
        }
    }

    public Projectile createProjectile(Position position, Position direction) {
        return new Projectile(position, direction, this);
    }

    public int getRange() {
        return range;
    }

    public int getBaseDamage() {
        return baseDamage;
    }

    public int getDelay() {
        return delay;
    }
}
