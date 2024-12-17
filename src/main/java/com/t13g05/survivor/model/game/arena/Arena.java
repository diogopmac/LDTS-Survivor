package com.t13g05.survivor.model.game.arena;

import com.t13g05.survivor.gui.LanternaGUI;
import com.t13g05.survivor.model.Position;
import com.t13g05.survivor.model.game.element.Projectile;
import com.t13g05.survivor.model.game.element.entity.Monster;
import com.t13g05.survivor.model.game.element.entity.Survivor;

import java.util.ArrayList;
import java.util.List;

public class Arena {
    private int width;
    private int height;
    private Survivor survivor;
    private List<Monster> monsters;
    private List<Projectile> projectiles;

    public Arena(int width, int height) {
        this.width = width;
        this.height = height;
        this.monsters = new ArrayList<>();
        this.projectiles = new ArrayList<>();
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Survivor getSurvivor() {
        return survivor;
    }

    public void setSurvivor(Survivor survivor) {
        this.survivor = survivor;
    }

    public List<Monster> getMonsters() {
        return monsters;
    }

    public void setMonsters(List<Monster> monsters) {
        this.monsters = monsters;
    }

    public List<Projectile> getProjectiles() {
        return projectiles;
    }

    public void setProjectiles(List<Projectile> projectiles) {
        this.projectiles = projectiles;
    }
}
