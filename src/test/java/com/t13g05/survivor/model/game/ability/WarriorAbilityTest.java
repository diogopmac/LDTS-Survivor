package com.t13g05.survivor.model.game.ability;

import com.t13g05.survivor.model.Position;
import com.t13g05.survivor.model.game.element.entity.Survivor;
import com.t13g05.survivor.model.game.element.entity.classes.Warrior;
import com.t13g05.survivor.model.weapon.Weapon;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class WarriorAbilityTest {
    private WarriorAbility warriorAbility;
    private Survivor survivor;
    private Weapon weapon;

    @BeforeEach
    public void setUp() {
        warriorAbility = new WarriorAbility(10,20);
        survivor = Mockito.mock(Survivor.class);
        weapon = Mockito.mock(Weapon.class);

        Mockito.when(survivor.getWeapon()).thenReturn(weapon);
        Mockito.when(survivor.getDamage()).thenReturn(20);
        Mockito.when(weapon.getBaseDamage()).thenReturn(10);
    }

    @Test
    public void useTest(){
        warriorAbility.use(survivor);
        Assertions.assertTrue(warriorAbility.isActive());
        Assertions.assertTrue(warriorAbility.onCooldown());

        Mockito.verify(survivor).setPreventLevelUp(true);
        Mockito.verify(survivor, Mockito.times(1)).getDamage();

        Mockito.verify(survivor).setDamage((20+10)*2);
    }

    @Test
    public void onCooldownTest(){
        warriorAbility.use(survivor);
        Assertions.assertTrue(warriorAbility.onCooldown());

        Mockito.verify(survivor).setDamage((20+10)*2);

        warriorAbility.use(survivor);
        Mockito.verify(survivor).setDamage((20+10)*2);
    }

    @Test
    public void isActiveTest(){
        warriorAbility.use(survivor);
        Assertions.assertTrue(warriorAbility.isActive());
        Assertions.assertTrue(warriorAbility.onCooldown());
        Mockito.verify(survivor).setPreventLevelUp(true);
    }

    @Test
    public void updateTest() throws Exception{
        warriorAbility.use(survivor);
        Assertions.assertTrue(warriorAbility.onCooldown());
        Mockito.verify(survivor).setDamage((20+10)*2);

        Thread.sleep(100);
        warriorAbility.update(survivor, System.currentTimeMillis());
        Mockito.verify(survivor).setDamage(20);
        Mockito.verify(survivor, Mockito.times(1)).setPreventLevelUp(false);
    }


}
