package com.t13g05.survivor.model.game.element.entity.classes;

import com.t13g05.survivor.model.Position;
import com.t13g05.survivor.model.game.ability.RogueAbility;
import com.t13g05.survivor.model.weapon.Weapon;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class RogueTest {
    private Rogue rogue;

    @BeforeEach
    public void setUp() {
        rogue = new Rogue(new Position(1,1), 100, "Bow");
    }

    @Test
    public void abilityTest() {
        Assertions.assertInstanceOf(RogueAbility.class, rogue.getAbility());
    }
}

