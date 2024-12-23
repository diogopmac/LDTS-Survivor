package com.t13g05.survivor.model.game.ability;

import com.t13g05.survivor.model.game.element.entity.Survivor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MageAbilityTest {
    private MageAbility mageAbility;
    private Survivor survivor;

    @BeforeEach
    public void setUp() {
        mageAbility = new MageAbility(10, 30);
        survivor = Mockito.mock(Survivor.class);
    }

    @Test
    public void useTest(){
        mageAbility.use(survivor);

        Assertions.assertTrue(mageAbility.isActive());
        Assertions.assertTrue(mageAbility.onCooldown());
        Mockito.verify(survivor).setShield(true);
        Mockito.verify(survivor).setPreventLevelUp(true);
    }

    @Test
    public void onCoolDownTest(){
        mageAbility.use(survivor);
        Assertions.assertTrue(mageAbility.onCooldown());

        mageAbility.use(survivor);
        Mockito.verify(survivor, Mockito.times(1)).setShield(true);
    }

    @Test
    public void isActiveTest() {
        mageAbility.use(survivor);
        Assertions.assertTrue(mageAbility.isActive());
        mageAbility.use(survivor);
        Assertions.assertTrue(mageAbility.isActive());
    }

    @Test
    public void updateTest() throws Exception{
        mageAbility.use(survivor);
        Assertions.assertTrue(mageAbility.onCooldown());
        Thread.sleep(100);

        Mockito.when(survivor.isShielded()).thenReturn(true);

        Assertions.assertTrue(survivor.isShielded());
        mageAbility.update(survivor, System.currentTimeMillis());

        Assertions.assertFalse(mageAbility.isActive());
        Mockito.verify(survivor, Mockito.times(1)).setShield(false);
        Mockito.verify(survivor, Mockito.times(1)).setPreventLevelUp(false);
    }

    @Test
    public void getCooldownTest() {
        mageAbility.getCooldown();
        Assertions.assertEquals(0, mageAbility.getCooldown());
        mageAbility.use(survivor);
        long now = System.currentTimeMillis();
        Assertions.assertEquals((30-(System.currentTimeMillis()-now))/1000+1, mageAbility.getCooldown());

    }
}
