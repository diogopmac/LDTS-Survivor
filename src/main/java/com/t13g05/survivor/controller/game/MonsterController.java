package com.t13g05.survivor.controller.game;

import com.t13g05.survivor.Game;
import com.t13g05.survivor.controller.Controller;
import com.t13g05.survivor.gui.Action;
import com.t13g05.survivor.model.Position;
import com.t13g05.survivor.model.game.arena.Arena;
import com.t13g05.survivor.model.game.element.entity.Monster;

import java.util.Set;

import static java.lang.Math.abs;

public class MonsterController extends GameController {
    private long lastMovement;

    public MonsterController(Arena arena) {
        super(arena);

        lastMovement = 0;
    }

    private void moveMonster(Monster monster, Position position) {
        monster.setPosition(position);
    }

    @Override
    public void step(Game game, Set<Action> actions, long time) {
        if (time - lastMovement > 500) {
            for (Monster monster : getModel().getMonsters()) {
                Position nextPos = nextMove(monster.getPosition());
                if (canMove(nextPos) && !getModel().getSurvivor().getPosition().equals(nextPos))
                    moveMonster(monster, nextPos);
                else if (getModel().getSurvivor().getPosition().equals(nextPos))
                    getModel().getSurvivor().damage(monster.getDamage());
            }
            lastMovement = time;
        }
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
