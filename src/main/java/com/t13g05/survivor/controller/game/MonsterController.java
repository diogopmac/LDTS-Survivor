package com.t13g05.survivor.controller.game;

import com.t13g05.survivor.Game;
import com.t13g05.survivor.controller.Controller;
import com.t13g05.survivor.gui.Action;
import com.t13g05.survivor.model.Position;
import com.t13g05.survivor.model.game.arena.Arena;
import com.t13g05.survivor.model.game.element.entity.Monster;

import java.util.Set;

public class MonsterController extends Controller<Arena> {
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
                moveMonster(monster, getRandomNeighbour(monster.getPosition()));
            }
            lastMovement = time;
        }
    }

    private Position getRandomNeighbour(Position position) {
        int n = (int) (Math.random() * 4);
        return switch (n) {
            case 0 -> new Position(position.x() + 1, position.y());
            case 1 -> new Position(position.x() - 1, position.y());
            case 2 -> new Position(position.x(), position.y() + 1);
            default -> new Position(position.x(), position.y() - 1);
        };
    }
}
