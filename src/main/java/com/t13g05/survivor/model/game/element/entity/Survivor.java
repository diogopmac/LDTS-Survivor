package com.t13g05.survivor.model.game.element.entity;

import com.t13g05.survivor.model.Position;
import com.t13g05.survivor.model.game.ability.Ability;
import com.t13g05.survivor.model.weapon.Weapon;

public class Survivor extends Entity {
    private Position direction = new Position(1, 0);
    private int level;
    private int experience;
    private int fireRateReduction;
    private final Weapon weapon;
    private final Ability ability;
    private boolean shield;
    private boolean preventLevelUp;
    protected String color;
    protected String character;

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
        this.shield = false;
        this.preventLevelUp = false;
        this.color = "#FFD700";
        this.character = "S";
    }

    public int necessaryExp() {
        return level*20 + 100;
    }

    public void levelUp() {
        this.level++;
    }

    public void giveExperience(int experience) {
        this.experience += experience;
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
    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getFireRateReduction() {
        return fireRateReduction;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public Ability getAbility() {
        return ability;
    }

    public boolean getPreventLevelUp() {
        return preventLevelUp;
    }
    public void setPreventLevelUp(boolean bool) {
        preventLevelUp = bool;
    }

    public boolean isShielded() {
        return shield;
    }
    public void setShield(boolean shield) {
        this.shield = shield;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public String getColor() {
        return color;
    }

    public String getCharacter() {
        return character;
    }
}
