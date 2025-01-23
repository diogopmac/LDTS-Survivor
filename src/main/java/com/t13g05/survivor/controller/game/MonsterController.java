package com.t13g05.survivor.controller.game;

import com.t13g05.survivor.Game;
import com.t13g05.survivor.gui.Action;
import com.t13g05.survivor.model.Position;
import com.t13g05.survivor.model.game.arena.Arena;
import com.t13g05.survivor.model.game.element.entity.Monster;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import static java.lang.Math.abs;

public class MonsterController extends GameController {
    private long lastMovement;
    private long lastSpawn;

    public MonsterController(Arena arena) {
        super(arena);

        lastMovement = 0;
        lastSpawn = 0;
    }

    private void moveMonster(Monster monster, Position position) {
        monster.setPosition(position);
    }

    private void spawnMonster() {
        Random rnd = new Random();
        Position position = new Position(-1, -1);

        while (!canMove(position)) {
            int random = rnd.nextInt(4);

            if (random <= 1) {
                int x = rnd.nextInt(1, getModel().getWidth() - 1);
                position = new Position(x, random == 0 ? 1 : getModel().getHeight() - 2);
            } else {
                int y = rnd.nextInt(1, getModel().getHeight() - 1);
                position = new Position(random == 2 ? 1 : getModel().getWidth() - 2, y);
            }
        }

        List<Monster> newMonsters = new ArrayList<>(getModel().getMonsters());
        newMonsters.add(new Monster(position,
                10 + getModel().getSurvivor().getLevel()* rnd.nextInt(16),
                10 + getModel().getSurvivor().getLevel()* rnd.nextInt(16)
        ));
        getModel().setMonsters(newMonsters);
    }

    @Override
    public void step(Game game, Set<Action> actions, long time) {
        if (time - lastMovement < 500) return;

        for (Monster monster : getModel().getMonsters()) {
            Position nextPos = nextMove(monster.getPosition());

            if (canMove(nextPos) && !getModel().getSurvivor().getPosition().equals(nextPos))
                moveMonster(monster, nextPos);
            else if (getModel().getSurvivor().getPosition().equals(nextPos))
                if (!getModel().getSurvivor().isShielded()){
                    getModel().getSurvivor().damage(monster.getDamage());
                }

        }

        lastMovement = time;

        if (time - lastSpawn < 1000) return;

        int chance = 10 + getModel().getSurvivor().getLevel();
        if (Math.random()*100 >= 100-chance) {
            spawnMonster();
        }

        lastSpawn = time;
    }

    private Position nextMove(Position position) {
        Position survivorPos = getModel().getSurvivor().getPosition();

        if (abs(survivorPos.x() - position.x()) > abs(survivorPos.y() - position.y())) {
            if (survivorPos.x() > position.x()) return new Position(position.x() +1, position.y());

            return new Position(position.x() -1, position.y());
        }

        if (survivorPos.y() > position.y()) return new Position(position.x(), position.y() +1);

        return new Position(position.x(), position.y() -1);
    }
}
