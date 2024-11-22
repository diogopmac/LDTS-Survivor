package com.t13g05.survivor.model.weapon;

public class Weapon {
    int delay;
    int base_damage;
    int projectile_type;
    int range;

    protected Weapon(int delay, int base_damage, int projectile_type, int range) {
        this.delay = delay;
        this.base_damage = base_damage;
        this.projectile_type = projectile_type;
        this.range = range;
    }
}
