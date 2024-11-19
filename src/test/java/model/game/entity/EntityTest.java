package model.game.entity;

import com.t13g05.survivor.model.game.entity.Entity;
import com.t13g05.survivor.model.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EntityTest {
    @Test
    public void position_test() {
        int x = 5;
        int y = 7;
        Entity entity = new Entity(x, y);

        Assertions.assertEquals(new Position(x, y), entity.getPosition());
    }

    @Test
    public void setPosition_test() {
        int x = 5;
        int y = 7;
        Entity entity = new Entity(x, y);
        Position newPosition = new Position(10, 10);
        entity.setPosition(newPosition);
        Assertions.assertEquals(newPosition, entity.getPosition());
    }
}
