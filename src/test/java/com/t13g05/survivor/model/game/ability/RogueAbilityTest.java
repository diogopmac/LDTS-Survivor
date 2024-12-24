package com.t13g05.survivor.model.game.ability;

import com.t13g05.survivor.Game;
import com.t13g05.survivor.model.Position;
import com.t13g05.survivor.model.game.element.entity.Survivor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.awt.desktop.SystemSleepEvent;

public class RogueAbilityTest {
    private RogueAbility rogueAbility;
    private Survivor survivor;

    @BeforeEach
    public void setUp() {
        rogueAbility = new RogueAbility(5, 20);
        survivor = Mockito.mock(Survivor.class);
    }

    @Test
    public void useValidForXTest(){
        Mockito.when(survivor.getPosition()).thenReturn(new Position(5, 5));
        Mockito.when(survivor.getDirection()).thenReturn(new Position(1, 0));

        rogueAbility.use(survivor);

        Mockito.verify(survivor).setPosition(new Position(10, 5));
        Assertions.assertTrue(rogueAbility.onCooldown());
    }

    @Test
    public void useInvalidForXTest(){
        Mockito.when(survivor.getPosition()).thenReturn(new Position(3, 1));
        Mockito.when(survivor.getDirection()).thenReturn(new Position(-1, 0));

        rogueAbility.use(survivor);

        Mockito.verify(survivor, Mockito.times(1)).setPosition(new Position(1, 1));
        Assertions.assertTrue(rogueAbility.onCooldown());
    }

    @Test
    public void useValidForYTest(){
        Mockito.when(survivor.getPosition()).thenReturn(new Position(5, 5));
        Mockito.when(survivor.getDirection()).thenReturn(new Position(0, 1));

        rogueAbility.use(survivor);

        Mockito.verify(survivor).setPosition(new Position(5, 10));
        Assertions.assertTrue(rogueAbility.onCooldown());
    }

    @Test
    public void useInvalidForYTest(){
        Mockito.when(survivor.getPosition()).thenReturn(new Position(3, 3));
        Mockito.when(survivor.getDirection()).thenReturn(new Position(0, -1));

        rogueAbility.use(survivor);

        Mockito.verify(survivor, Mockito.times(1)).setPosition(new Position(3, 1));
        Assertions.assertTrue(rogueAbility.onCooldown());
    }

    @Test
    public void useGreaterBoundaryXTest(){
        Mockito.when(survivor.getPosition()).thenReturn(new Position(Game.width-3, Game.height-1));
        Mockito.when(survivor.getDirection()).thenReturn(new Position(1, 0));

        rogueAbility.use(survivor);

        Mockito.verify(survivor).setPosition(new Position(Game.width-1, Game.height-1));
        Assertions.assertTrue(rogueAbility.onCooldown());
    }

    @Test
    public void useGreaterBoundaryYTest(){
        Mockito.when(survivor.getPosition()).thenReturn(new Position(Game.width-1, Game.height-3));
        Mockito.when(survivor.getDirection()).thenReturn(new Position(0, 1));

        rogueAbility.use(survivor);

        Mockito.verify(survivor).setPosition(new Position(Game.width-1, Game.height-1));
        Assertions.assertTrue(rogueAbility.onCooldown());
    }

    @Test
    public void updateTest() throws Exception{
        Mockito.when(survivor.getPosition()).thenReturn(new Position(10, 10));
        Mockito.when(survivor.getDirection()).thenReturn(new Position(0, 1));

        rogueAbility.use(survivor);
        Assertions.assertTrue(rogueAbility.onCooldown());
        Mockito.verify(survivor).setPosition(new Position(10, 15));

        Mockito.when(survivor.getPosition()).thenReturn(new Position(10, 15));

        Thread.sleep(100);
        rogueAbility.update(survivor, System.currentTimeMillis());
        Assertions.assertFalse(rogueAbility.onCooldown());
        rogueAbility.use(survivor);
        Mockito.verify(survivor).setPosition(new Position(10, 20));
    }

}
