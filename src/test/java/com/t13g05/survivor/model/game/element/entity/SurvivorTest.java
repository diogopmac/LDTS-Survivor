package com.t13g05.survivor.model.game.element.entity;

import com.t13g05.survivor.model.Position;
import com.t13g05.survivor.model.game.ability.Ability;
import com.t13g05.survivor.model.weapon.Weapon;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class SurvivorTest {
    private Survivor survivor;
    private Weapon weapon;
    private Ability ability;

    @BeforeEach
    public void setUp() {
        ability = Mockito.mock(Ability.class);
        weapon = Mockito.mock(Weapon.class);

        survivor = new Survivor(new Position(1,1), 100, "Sword", ability);

        Mockito.when(weapon.getRange()).thenReturn(10);
        Mockito.when(weapon.getDelay()).thenReturn(800);
        Mockito.when(weapon.getBaseDamage()).thenReturn(10);
    }

    @Test
    public void constructorTest() {
        Assertions.assertNotNull(survivor);
        Assertions.assertEquals(0, survivor.getLevel());
        Assertions.assertEquals(0, survivor.getDamage());
        Assertions.assertEquals(0, survivor.getExperience());
        Assertions.assertEquals(0, survivor.getFireRateReduction());

        Assertions.assertEquals(new Position(1,0), survivor.getDirection());
    }

    @Test
    public void giveExperienceTest() {
        survivor.giveExperience(50);
        Assertions.assertEquals(50, survivor.getExperience());
    }

    @Test
    public void necessaryXPTest(){
        Assertions.assertEquals(0, survivor.getExperience());
        Assertions.assertEquals(100, survivor.necessaryExp());

        survivor.levelUp();
        Assertions.assertEquals(120, survivor.necessaryExp());
    }

    @Test
    public void levelUpTest() {
        survivor.levelUp();
        Assertions.assertEquals(1, survivor.getLevel());
    }

    @Test
    public void hpUpTest() {
        survivor.upHealth();
        Assertions.assertEquals(200, survivor.getHealth());
    }

    @Test
    public void dmgUpTest() {
        survivor.upDamage();
        Assertions.assertEquals(20, survivor.getDamage());
    }

    @Test
    public void frUpTest() {
        survivor.upFireRate();
        Assertions.assertEquals(weapon.getDelay()/20, survivor.getFireRateReduction());
    }

    @Test
    public void setDirectionTest() {
        survivor.setDirection(new Position(0,1));
        Assertions.assertEquals(new Position(0,1), survivor.getDirection());
    }

    @Test
    public void setExperienceTest() {
        survivor.setExperience(100);
        Assertions.assertEquals(100, survivor.getExperience());
    }

    @Test
    public void setDamageTest() {
        survivor.setDamage(100);
        Assertions.assertEquals(100, survivor.getDamage());
    }

    @Test
    public void shieldTest(){
        Assertions.assertFalse(survivor.isShielded());
        survivor.setShield(true);
        Assertions.assertTrue(survivor.isShielded());
    }

    @Test
    public void preventLevelUpTest(){
        Assertions.assertFalse(survivor.getPreventLevelUp());
        survivor.setPreventLevelUp(true);
        Assertions.assertTrue(survivor.getPreventLevelUp());
    }

    @Test
    public void applyDamageTest(){
        survivor.damage(70);
        Assertions.assertEquals(30, survivor.getHealth());
    }
}
