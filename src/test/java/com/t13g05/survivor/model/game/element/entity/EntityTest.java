package com.t13g05.survivor.model.game.element.entity;

import com.t13g05.survivor.model.game.element.entity.Entity;
import com.t13g05.survivor.model.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EntityTest {
    @Test
    public void setup_test(){
        Entity entity = new Entity();
        Assertions.assertNotNull(entity);
        Assertions.assertEquals(entity.getHealth(),0);
        Assertions.assertEquals(entity.getPosition(),new Position(0,0));

        Entity entity_with_position = new Entity(new Position(1,1));
        Assertions.assertNotNull(entity_with_position);
        Assertions.assertEquals(entity_with_position.getPosition(),new Position(1,1));
        Assertions.assertEquals(entity_with_position.getHealth(),100);
    }

    @Test
    public void position_test() {
        int x = 5;
        int y = 7;
        Entity entity = new Entity(new Position(x, y));

        Assertions.assertEquals(new Position(x, y), entity.getPosition());
    }

    @Test
    public void setPosition_test() {
        int x = 5;
        int y = 7;
        Entity entity = new Entity(new Position(x, y));
        Position newPosition = new Position(10, 10);
        entity.setPosition(newPosition);
        Assertions.assertEquals(newPosition, entity.getPosition());
    }
}
