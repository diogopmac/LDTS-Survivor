package com.t13g05.survivor.controller.game;

import com.t13g05.survivor.Game;
import com.t13g05.survivor.gui.Action;
import com.t13g05.survivor.model.Position;
import com.t13g05.survivor.model.game.arena.Arena;
import com.t13g05.survivor.model.game.element.Projectile;
import com.t13g05.survivor.model.game.element.entity.Monster;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class ProjectileController extends GameController {
    public ProjectileController(Arena arena) {
        super(arena);
    }

    private boolean hit(Position position, Projectile projectile) {
        for (Monster monster : getModel().getMonsters()) {
            if (monster.getPosition().equals(position)) {
                monster.damage(projectile.getWeapon().getBaseDamage());
                if (monster.getHealth() == 0) {
                    List<Monster> newMonsters = new ArrayList<>(getModel().getMonsters());
                    newMonsters.remove(monster);
                    getModel().setMonsters(newMonsters);

                    Random rnd = new Random();
                    getModel().getSurvivor().giveExperience(10 + rnd.nextInt(21));
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public void step(Game game, Set<Action> actions, long time) {
        List<Projectile> newProjectiles = new ArrayList<>(getModel().getProjectiles());
        for (Projectile projectile : getModel().getProjectiles()) {
            if (projectile.getDistanceTraveled() >= projectile.getWeapon().getRange() || hit(projectile.getPosition(), projectile)) {
                newProjectiles.remove(projectile);
                continue;
            }
            Position nextPos = new Position(projectile.getPosition().x() + projectile.getDirection().x(),
                                                projectile.getPosition().y() + projectile.getDirection().y());
            projectile.setPosition(nextPos);
        }
        getModel().setProjectiles(newProjectiles);
    }
}
