package com.t13g05.survivor.model.game.element.entity;

import com.t13g05.survivor.gui.LanternaGUI;
import com.t13g05.survivor.model.Position;
import com.t13g05.survivor.model.game.ability.Ability;
import com.t13g05.survivor.model.weapon.Weapon;

public class Survivor extends Entity {
    Weapon weapon;
    Position direction = new Position(1, 0);
    int fireRateReduction;
    int level;
    int experience;
    Ability ability;
    boolean shield = false;

    public Survivor(Position position, int health, String weapon, Ability ability) {
        super(position, health);
        try {
            this.weapon = (Weapon) Class.forName("com.t13g05.survivor.model.weapon." + weapon).newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        this.level = 0;
        this.experience = 0;
        this.fireRateReduction = 0;
        this.ability = ability;
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

    public int getLevel() {
        return level;
    }

    public int getExperience() {
        return experience;
    }

    public int necessaryExp() {
        return level*20 + 100;
    }

    public void giveExperience(int experience) {
        this.experience += experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void levelUp() {
        this.level++;
    }

    public int getFireRateReduction() {
        return fireRateReduction;
    }

    public void upFireRate() {
        this.fireRateReduction = getFireRateReduction() + weapon.getDelay()/20;
    }

    public void upHealth() {
        this.health = getHealth() + 100;
    }

    public void upDamage(){
        this.damage = getDamage() + weapon.getBaseDamage();
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public boolean isShielded() {
        return shield;
    }

    public void setShield(boolean shield) {
        this.shield = shield;
    }

    public Ability getAbility() {
        return ability;
    }
}
