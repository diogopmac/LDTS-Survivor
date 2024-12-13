package com.t13g05.survivor.controller.menu;

import com.t13g05.survivor.Game;
import com.t13g05.survivor.controller.Controller;
import com.t13g05.survivor.gui.Action;
import com.t13g05.survivor.model.game.arena.Arena;
import com.t13g05.survivor.model.menu.ControlsMenu;
import com.t13g05.survivor.model.menu.MainMenu;
import com.t13g05.survivor.model.menu.Menu;
import com.t13g05.survivor.state.ControlsMenuState;
import com.t13g05.survivor.state.GameState;
import com.t13g05.survivor.state.MainMenuState;

import java.util.Set;

public class EntryController extends Controller<Menu> {
    public EntryController(Menu menu) {
        super(menu);
    }

    @Override
    public void step(Game game, Set<Action> actions, long time){
        for (Action action : actions) {
            switch (getModel().getEntry().getType()) {
                case START_GAME:
                    if (action == Action.SELECT){
                        game.setState(new GameState(new Arena(70,45)));
                    }
                    break;
                case OPTIONS:
                    // abre o ecrã de opções
                case CONTROLS:
                    if (action == Action.SELECT){
                        game.setState(new ControlsMenuState(new ControlsMenu()));
                        break;
                    }
                case QUIT:
                    if (action == Action.SELECT){
                        game.setState(null);
                    }
                    break;
                case BACK:
                    if (action == Action.SELECT){
                        game.setState(new MainMenuState(new MainMenu()));
                    }
            }
        }
    }
}
