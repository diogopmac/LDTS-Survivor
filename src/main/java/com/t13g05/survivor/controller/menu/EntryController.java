package com.t13g05.survivor.controller.menu;

import com.t13g05.survivor.Game;
import com.t13g05.survivor.GameConfig;
import com.t13g05.survivor.controller.Controller;
import com.t13g05.survivor.gui.Action;
import com.t13g05.survivor.model.game.arena.Arena;
import com.t13g05.survivor.model.game.arena.ArenaCreator;
import com.t13g05.survivor.model.game.arena.ArenaFactory;
import com.t13g05.survivor.model.menu.ControlsMenu;
import com.t13g05.survivor.model.menu.MainMenu;
import com.t13g05.survivor.model.menu.Menu;
import com.t13g05.survivor.model.menu.SettingsMenu;
import com.t13g05.survivor.state.ControlsMenuState;
import com.t13g05.survivor.state.GameState;
import com.t13g05.survivor.state.MainMenuState;
import com.t13g05.survivor.state.SettingsMenuState;

import java.util.Set;

public class EntryController extends Controller<Menu> {
    public EntryController(Menu menu) {
        super(menu);
    }

    @Override
    public void step(Game game, Set<Action> actions, long time) {
        GameState gameState;

        switch (getModel().getEntry().getType()) {
            case START_GAME:
                GameConfig config = GameConfig.getInstance();
                ArenaFactory factory = new ArenaCreator();
                Arena arena = factory.createArena(
                        Game.width,
                        Game.height,
                        config.getSelectedClass(),
                        config.getSelectedWeapon()
                );
                game.setState(new GameState(arena));
                break;

            case OPTIONS:
                game.setState(new SettingsMenuState(new SettingsMenu()));
                break;

            case CONTROLS:
                game.setState(new ControlsMenuState(new ControlsMenu()));
                break;

            case QUIT:
                game.setState(null);
                break;

            case BACK:
                game.setState(new MainMenuState(new MainMenu()));
                break;

            case HP_UP:
                game.loadPreviousState();
                gameState = (GameState) game.getState();

                gameState.getModel().getSurvivor().upHealth();
                break;

            case DMG_UP:
                game.loadPreviousState();
                gameState = (GameState) game.getState();

                gameState.getModel().getSurvivor().upDamage();
                break;

            case FR_UP:
                game.loadPreviousState();
                gameState = (GameState) game.getState();

                gameState.getModel().getSurvivor().upFireRate();
                break;

            case RESUME:
                game.loadPreviousState();
                break;

        }
    }
}
