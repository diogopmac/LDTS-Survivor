package com.t13g05.survivor.controller.game;

import com.t13g05.survivor.controller.Controller;
import com.t13g05.survivor.model.Position;
import com.t13g05.survivor.model.game.arena.Arena;
import com.t13g05.survivor.model.game.element.entity.Monster;

public abstract class GameController extends Controller<Arena> {
    public GameController(Arena arena) {
        super(arena);
    }

    protected boolean canMove(Position position) {
        if (position.x() >= getModel().getWidth()-1 || position.x() <= 0) return false;
        if (position.y() >= getModel().getHeight()-1 || position.y() <= 0) return false;
        for (Monster monster : getModel().getMonsters()) {
            if (monster.getPosition().equals(position)) return false;
        }
        return true;
    }
}
