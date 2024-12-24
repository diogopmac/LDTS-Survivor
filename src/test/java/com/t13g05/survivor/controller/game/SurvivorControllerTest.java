package com.t13g05.survivor.controller.game;

import com.t13g05.survivor.Game;
import com.t13g05.survivor.gui.Action;
import com.t13g05.survivor.model.Position;
import com.t13g05.survivor.model.game.ability.Ability;
import com.t13g05.survivor.model.game.arena.Arena;
import com.t13g05.survivor.model.game.element.entity.Survivor;
import com.t13g05.survivor.model.weapon.Weapon;
import com.t13g05.survivor.state.LevelUpMenuState;
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
        Assertions.assertFalse(survivorController.canMove(new Position(1,0)));
        Assertions.assertEquals(new Position(1,1), arena.getSurvivor().getPosition());
        Assertions.assertEquals(new Position(1,0), arena.getSurvivor().getDirection());

        survivorController.step(game, Set.of(Action.LEFT), 102);
        Assertions.assertFalse(survivorController.canMove(new Position(0,1)));
        Assertions.assertEquals(new Position(1,1), arena.getSurvivor().getPosition());
        Assertions.assertEquals(new Position(1,0), arena.getSurvivor().getDirection());
    }

    @Test
    public void validMoveTest(){
        survivorController.step(game, Set.of(Action.DOWN), 100);
        Assertions.assertTrue(survivorController.canMove(new Position(1,2)));
        Assertions.assertEquals(new Position(1,2), arena.getSurvivor().getPosition());
        Assertions.assertEquals(new Position(0,1), arena.getSurvivor().getDirection());

        survivorController.step(game, Set.of(Action.RIGHT), 150);
        Assertions.assertTrue(survivorController.canMove(new Position(2,2)));
        Assertions.assertEquals(new Position(2,2), arena.getSurvivor().getPosition());
        Assertions.assertEquals(new Position(1,0), arena.getSurvivor().getDirection());

        survivorController.step(game, Set.of(Action.LEFT), 200);
        Assertions.assertTrue(survivorController.canMove(new Position(1,2)));
        Assertions.assertEquals(new Position(1,2), arena.getSurvivor().getPosition());
        Assertions.assertEquals(new Position(-1,0), arena.getSurvivor().getDirection());


        survivorController.step(game, Set.of(Action.UP), 250);
        Assertions.assertTrue(survivorController.canMove(new Position(1,1)));
        Assertions.assertEquals(new Position(1,1), arena.getSurvivor().getPosition());
        Assertions.assertEquals(new Position(0,-1), arena.getSurvivor().getDirection());
    }

    @Test
    public void upperBoundsCanMoveTest(){
        survivor.setPosition(new Position(Game.width-1, Game.height-1));
        survivorController.step(game, Set.of(Action.UP), 100);
        Assertions.assertFalse(survivorController.canMove(new Position(Game.width,Game.height-1)));
        Assertions.assertEquals(new Position(Game.width-1,Game.height-1), arena.getSurvivor().getPosition());
        Assertions.assertEquals(new Position(1,0), arena.getSurvivor().getDirection());

        survivorController.step(game, Set.of(Action.LEFT), 150);
        Assertions.assertFalse(survivorController.canMove(new Position(Game.width-1,Game.height)));
        Assertions.assertEquals(new Position(Game.width-1,Game.height-1), arena.getSurvivor().getPosition());
        Assertions.assertEquals(new Position(1,0), arena.getSurvivor().getDirection());

    }

    @Test
    public void useTest(){
        survivorController.step(game, Set.of(Action.USE), 100);
        Mockito.verify(ability).use(survivor);

        Mockito.verify(ability).update(survivor, 100);
    }

    @Test
    public void levelUpTest(){
        Assertions.assertEquals(0, survivor.getLevel());
        Assertions.assertEquals(0, survivor.getExperience());
        survivor.giveExperience(100);
        Assertions.assertEquals(100, survivor.getExperience());

        survivorController.step(game, Set.of(Action.UP), 100);
        Assertions.assertEquals(0, survivor.getExperience());
        Assertions.assertEquals(1, survivor.getLevel());

        Mockito.verify(game).saveState();
        Mockito.verify(game).setState(Mockito.any(LevelUpMenuState.class));

        survivor.giveExperience(100);
        Assertions.assertEquals(100, survivor.getExperience());
        survivorController.step(game, Set.of(Action.LEFT), 100);
        Assertions.assertEquals(100, survivor.getExperience());
        Assertions.assertEquals(1, survivor.getLevel());

    }
}
