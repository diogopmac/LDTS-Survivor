package com.t13g05.survivor.model.game.element;

import com.t13g05.survivor.model.Position;
import com.t13g05.survivor.model.game.element.entity.Entity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ElementTest {
    @Test
    public void position_test() {
        int x = 2;
        int y = 9;
        Element element = new Element(new Position(x, y));

        Assertions.assertEquals(new Position(x, y), element.getPosition());
    }

    @Test
    public void setPosition_test() {
        int x = 1;
        int y = 2;
        Element element = new Element(new Position(x, y));
        Position newPosition = new Position(10, 10);
        element.setPosition(newPosition);
        Assertions.assertEquals(newPosition, element.getPosition());
    }

    @Test
    public void defaultConstructor_test() {
        Element element = new Element();
        Assertions.assertNotNull(element);
    }

    @Test
    public void constructor_test(){
        Element element = new Element(new Position(1, 1));
        Assertions.assertNotNull(element);
    }
}
