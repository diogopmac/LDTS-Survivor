package com.t13g05.survivor.controller.game;

import com.t13g05.survivor.Game;
import com.t13g05.survivor.controller.Controller;
import com.t13g05.survivor.gui.Action;
import com.t13g05.survivor.model.Position;
import com.t13g05.survivor.model.game.arena.Arena;
import com.t13g05.survivor.model.game.element.entity.Monster;

import java.util.Set;

public class SurvivorController extends GameController {
    public SurvivorController(Arena arena) {
        super(arena);
    }

    private void moveSurvivor(int x, int y) {
        Position newPosition = new Position(getModel().getSurvivor().getPosition().x() +x,
                                            getModel().getSurvivor().getPosition().y() +y);
        if (canMove(newPosition)) getModel().getSurvivor().setPosition(newPosition);
    }

    @Override
    public void step(Game game, Set<Action> actions, long time) {
        for (Action action : actions) {
            switch (action) {
                case UP -> moveSurvivor(0, -1);
                case DOWN -> moveSurvivor(0, 1);
                case LEFT -> moveSurvivor(-1, 0);
                case RIGHT -> moveSurvivor(1, 0);
            }
        }
    }
}
