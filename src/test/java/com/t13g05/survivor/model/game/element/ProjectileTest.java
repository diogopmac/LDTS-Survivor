package com.t13g05.survivor.model.game.element;

import com.t13g05.survivor.model.Position;
import com.t13g05.survivor.model.weapon.Weapon;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ProjectileTest {
    private Weapon weapon;

    @BeforeEach
    public void setUp() {
        weapon = Mockito.mock(Weapon.class);
        Mockito.when(weapon.getRange()).thenReturn(3);
    }

    @Test
    public void testConstructor() {
        Projectile projectile = new Projectile(new Position(5,5), new Position(1,0), weapon);
        Assertions.assertNotNull(projectile);
        Assertions.assertEquals(projectile.getPosition().x(), 6);
        Assertions.assertEquals(projectile.getPosition().y(), 5);
        Assertions.assertEquals(projectile.getDirection().x(),1);
        Assertions.assertEquals(projectile.getDirection().y(),0);
        Assertions.assertEquals(projectile.getWeapon(), weapon);
    }

    @Test
    public void testSetPosition() {
        Position position = new Position(5,5);
        Position direction = new Position(0,1);
        Projectile projectile = new Projectile(position,direction,weapon);
        Assertions.assertEquals(projectile.getPosition(), new Position(5,6));
        Assertions.assertEquals(projectile.getDirection(), direction);

        projectile.setPosition(new Position(5, 7));
        projectile.setPosition(new Position(5, 8));
        projectile.setPosition(new Position(5, 9));
        Assertions.assertEquals(projectile.getDistanceTraveled(), 3);
        Assertions.assertEquals(weapon.getRange(), 3);
        projectile.setPosition(new Position(5, 10));
        Assertions.assertEquals(projectile.getDistanceTraveled(), 4);

        Assertions.assertEquals(projectile.getPosition(), new Position(5,10));


    }
}
