package com.t13g05.survivor.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.t13g05.survivor.model.Position;
import org.mockito.Mockito;

public class PositionTest {
    private Position position;

    @BeforeEach
    public void setUp() {
        position = new Position(2,2);
    }

    @Test
    public void getx_test(){
        Assertions.assertEquals(position.x(), 2);
    }

    @Test
    public void gety_test(){
        Assertions.assertEquals(position.y(), 2);
    }

    @Test
    public void equals_test(){
        Position position2 = new Position(2,2);
        Assertions.assertEquals(position, position2);
    }

    @Test
    public void notEquals_test(){
        Position position2 = new Position(2,6);
        Position position3 = new Position(6,2);
        Assertions.assertNotEquals(position, position2);
        Assertions.assertNotEquals(position, position3);
    }

    @Test
    public void hashCode_test(){
        Position position2 = new Position(2,2);
        Assertions.assertEquals(position.hashCode(), position2.hashCode());
    }

    @Test
    public void arenaBounds_test(){
        int arenaWidth = 10, arenaHeight = 10;
        Position position = new Position(5,5);
        Position newPosition = new Position(
                Math.max(0, Math.min(15, position.x())),
                Math.max(0, Math.min(10, position.y()))
        );

        Assertions.assertTrue(newPosition.x() < arenaWidth && newPosition.y() < arenaHeight);
        Assertions.assertTrue(newPosition.x() > 0 && newPosition.y() > 0);
    }

    @Test
    public void arenaOutOfBounds_test(){
        int arenaWidth = 10, arenaHeight = 10;
        Position newPosition = new Position(arenaWidth+1, arenaHeight+1);
        Assertions.assertFalse(newPosition.x() < arenaWidth && newPosition.y() < arenaHeight);
    }

    @Test
    public void negativeValue_test(){
        Position position = new Position(-1,2);
        Assertions.assertFalse(position.x() > 0);
    }
}
