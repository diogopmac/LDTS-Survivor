package com.t13g05.survivor.model.game.element.entity;

import com.t13g05.survivor.model.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MonsterTest {
    private Monster monster;
    private Monster monsterWithAttributes;

    @BeforeEach
    public void setUp() {
        monster = new Monster(new Position(2,2), 100, 10);
        monsterWithAttributes = new Monster(new Position(3,3), 14, 23);
    }

    @Test
    public void testMonster() {
        Assertions.assertNotNull(monster);
        Assertions.assertEquals(10, monster.getDamage());
        Assertions.assertEquals(100, monster.getHealth());

        Assertions.assertNotNull(monsterWithAttributes);
        Assertions.assertEquals(23, monsterWithAttributes.getDamage());
        Assertions.assertEquals(14, monsterWithAttributes.getHealth());
    }
}
