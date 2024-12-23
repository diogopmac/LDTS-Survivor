package com.t13g05.survivor.controller.game;

import com.t13g05.survivor.Game;
import com.t13g05.survivor.gui.Action;
import com.t13g05.survivor.model.game.arena.Arena;
import com.t13g05.survivor.model.game.element.entity.Monster;
import com.t13g05.survivor.model.game.element.entity.Survivor;
import com.t13g05.survivor.state.GameOverMenuState;
import com.t13g05.survivor.state.GameState;
import com.t13g05.survivor.state.PauseMenuState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ArenaControllerTest {
    private ArenaController arenaController;
    private Arena arena;
    private Game game;
    private SurvivorController survivorController;
    private MonsterController monsterController;
    private ProjectileController projectileController;
    private Set<Action> actions;

    @BeforeEach
    public void setUp() throws Exception {
        arena = Mockito.mock(Arena.class);
        game = Mockito.mock(Game.class);
        survivorController = Mockito.mock(SurvivorController.class);
        monsterController = Mockito.mock(MonsterController.class);
        projectileController = Mockito.mock(ProjectileController.class);

        Survivor survivor = Mockito.mock(Survivor.class);
        Mockito.when(arena.getSurvivor()).thenReturn(survivor);

        arenaController = new ArenaController(arena);

        actions = new HashSet<>();
    }


    @Test
    public void pauseMenuTest(){
        actions.add(Action.QUIT);

        arenaController.step(game, actions, 0);

        Mockito.verify(game).saveState();
        Mockito.verify(game).setState(Mockito.any(PauseMenuState.class));
    }

    @Test
    public void gameOverTest() throws Exception{
        Survivor survivor = Mockito.mock(Survivor.class);
        arena.setSurvivor(survivor);
        Mockito.when(arena.getSurvivor()).thenReturn(survivor);
        Mockito.when(arena.getSurvivor().getHealth()).thenReturn(0);

        arenaController.step(game, actions, 0);

        Mockito.verify(game).setState(Mockito.any(GameOverMenuState.class));
    }
}
