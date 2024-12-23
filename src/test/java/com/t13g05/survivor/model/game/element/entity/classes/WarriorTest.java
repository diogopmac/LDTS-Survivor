package com.t13g05.survivor.model.game.element.entity.classes;

import com.t13g05.survivor.model.Position;
import com.t13g05.survivor.model.game.ability.MageAbility;
import com.t13g05.survivor.model.game.ability.WarriorAbility;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WarriorTest {
    private Warrior warrior;

    @BeforeEach
    public void setUp() {
        warrior = new Warrior(new Position(1,1), 100, "Bow");
    }

    @Test
    public void abilityTest() {
        Assertions.assertInstanceOf(WarriorAbility.class, warrior.getAbility());
    }
}
