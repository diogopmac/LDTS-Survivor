package com.t13g05.survivor.controller.game;

import com.t13g05.survivor.Game;
import com.t13g05.survivor.controller.Controller;
import com.t13g05.survivor.gui.Action;
import com.t13g05.survivor.model.Position;
import com.t13g05.survivor.model.game.arena.Arena;
import com.t13g05.survivor.model.game.element.Projectile;
import com.t13g05.survivor.model.game.element.entity.Monster;
import com.t13g05.survivor.model.game.element.entity.Survivor;
import com.t13g05.survivor.model.weapon.Weapon;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SurvivorController extends GameController {
    private long lastShot;
    private long lastMovement;

    public SurvivorController(Arena arena) {
        super(arena);

        lastShot = 0;
        lastMovement = 0;
    }

    private void moveSurvivor(int x, int y) {
        Position newPosition = new Position(getModel().getSurvivor().getPosition().x() +x,
                                            getModel().getSurvivor().getPosition().y() +y);
        if (canMove(newPosition)) {
            getModel().getSurvivor().setPosition(newPosition);
            getModel().getSurvivor().setDirection(new Position(x, y));
        }
    }

    private void shoot(Position position, Position direction, Weapon weapon) {
        Projectile projectile = weapon.createProjectile(position, direction);
        List<Projectile> newProjectiles = new ArrayList<>(getModel().getProjectiles());
        newProjectiles.add(projectile);
        getModel().setProjectiles(newProjectiles);
    }

    @Override
    public void step(Game game, Set<Action> actions, long time) {
        Survivor survivor = getModel().getSurvivor();
        while (survivor.getExperience() >= survivor.necessaryExp()) {
            survivor.setExperience(survivor.getExperience() - survivor.necessaryExp());
            survivor.levelUp();
        }
        if (time - lastMovement < 50) return;
        for (Action action : actions) {
            switch (action) {
                case UP -> moveSurvivor(0, -1);
                case DOWN -> moveSurvivor(0, 1);
                case LEFT -> moveSurvivor(-1, 0);
                case RIGHT -> moveSurvivor(1, 0);
                case SHOOT -> {
                    if (time - lastShot > getModel().getSurvivor().getWeapon().getDelay()) {
                        shoot(getModel().getSurvivor().getPosition(), getModel().getSurvivor().getDirection(), getModel().getSurvivor().getWeapon());
                        lastShot = time;
                    }
                }
            }
        }
        lastMovement = time;
    }
}
