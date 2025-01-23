package com.t13g05.survivor.model.game.element.entity.classes;

import com.t13g05.survivor.model.Position;
import com.t13g05.survivor.model.game.ability.MageAbility;
import com.t13g05.survivor.model.weapon.Weapon;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MageTest {
    private Mage mage;

    @BeforeEach
    public void setUp() {
        mage = new Mage(new Position(1,1),"Bow");
    }

    @Test
    public void abilityTest() {
        Assertions.assertInstanceOf(MageAbility.class, mage.getAbility());
    }
}
