package com.t13g05.survivor.controller.game;

import com.t13g05.survivor.Game;
import com.t13g05.survivor.gui.Action;
import com.t13g05.survivor.model.Position;
import com.t13g05.survivor.model.game.ability.Ability;
import com.t13g05.survivor.model.game.arena.Arena;
import com.t13g05.survivor.model.game.element.entity.Survivor;
import com.t13g05.survivor.model.weapon.Weapon;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.awt.*;
import java.util.Set;

public class SurvivorControllerTest {
    private Arena arena;
    private SurvivorController survivorController;
    private Survivor survivor;
    private Game game;
    private Ability ability;

    @BeforeEach
    public void setUp() {
        game = Mockito.mock(Game.class);
        ability = Mockito.mock(Ability.class);

        arena = new Arena(70, 45);
        survivor = new Survivor(new Position(1,1), 100, "Bow", ability);
        arena.setSurvivor(survivor);

        survivorController = new SurvivorController(arena);
    }

    @Test
    public void invalidMoveTest(){
        survivorController.step(game, Set.of(Action.UP), 100);
        Assertions.assertEquals(new Position(1,1), arena.getSurvivor().getPosition());
        Assertions.assertEquals(new Position(1,0), arena.getSurvivor().getDirection());
        survivorController.step(game, Set.of(Action.LEFT), 102);
        Assertions.assertEquals(new Position(1,1), arena.getSurvivor().getPosition());
        Assertions.assertEquals(new Position(1,0), arena.getSurvivor().getDirection());
    }

    @Test
    public void validMoveTest(){
        survivorController.step(game, Set.of(Action.DOWN), 100);
        Assertions.assertEquals(new Position(1,2), arena.getSurvivor().getPosition());
        Assertions.assertEquals(new Position(0,1), arena.getSurvivor().getDirection());

        survivorController.step(game, Set.of(Action.RIGHT), 150);
        Assertions.assertEquals(new Position(2,2), arena.getSurvivor().getPosition());
        Assertions.assertEquals(new Position(1,0), arena.getSurvivor().getDirection());

        survivorController.step(game, Set.of(Action.LEFT), 200);
        Assertions.assertEquals(new Position(1,2), arena.getSurvivor().getPosition());
        Assertions.assertEquals(new Position(-1,0), arena.getSurvivor().getDirection());


        survivorController.step(game, Set.of(Action.UP), 250);
        Assertions.assertEquals(new Position(1,1), arena.getSurvivor().getPosition());
        Assertions.assertEquals(new Position(0,-1), arena.getSurvivor().getDirection());
    }
}
