package com.t13g05.survivor.controller.menu;

import com.t13g05.survivor.Game;
import com.t13g05.survivor.controller.Controller;
import com.t13g05.survivor.gui.Action;
import com.t13g05.survivor.model.menu.Menu;

import java.util.Set;

public class EntryController extends Controller<Menu> {
    public EntryController(Menu menu) {
        super(menu);
    }

    @Override
    public void step(Game game, Set<Action> action, long time){
        switch (getModel().getEntry().getType()) {
            case START_GAME:
                // começa o jogo
            case CONTROLS:
                // abre o ecrã de controlos
            case OPTIONS:
                // abre o ecrã de opções
            case QUIT:
                // sai do jogo
        }
    }
}
