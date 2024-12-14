package com.t13g05.survivor.controller.game;

import com.t13g05.survivor.Game;
import com.t13g05.survivor.controller.Controller;
import com.t13g05.survivor.model.game.arena.Arena;
import com.t13g05.survivor.gui.Action;
import com.t13g05.survivor.model.menu.MainMenu;
import com.t13g05.survivor.state.MainMenuState;

import java.util.Set;

public class ArenaController extends Controller<Arena> {
    private final SurvivorController survivorController;
    private final MonsterController monsterController;

    public ArenaController(Arena arena) {
        super(arena);

        survivorController = new SurvivorController(arena);
        monsterController = new MonsterController(arena);
    }

    public void step(Game game, Set<Action> actions, long time) {
        for (Action action : actions) {
            if (action == Action.QUIT) {
                game.setState(new MainMenuState(new MainMenu()));
                return;
            }
        }
        survivorController.step(game, actions, time);
        monsterController.step(game, actions, time);
    }
}
