package com.t13g05.survivor.model.weapon;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WeaponTest {
    @Test
    void sword_init_Test() {
        Sword sword = new Sword();

        Assertions.assertNotNull(sword);

        Assertions.assertEquals(800, sword.delay);
        Assertions.assertEquals(50, sword.base_damage);
        Assertions.assertEquals(2, sword.projectile_type);
        Assertions.assertEquals(2, sword.range);
    }

    @Test
    void pistol_init_Test() {
        Pistol pistol = new Pistol();

        Assertions.assertNotNull(pistol);

        Assertions.assertEquals(1500, pistol.delay);
        Assertions.assertEquals(40, pistol.base_damage);
        Assertions.assertEquals(1, pistol.projectile_type);
        Assertions.assertEquals(15, pistol.range);
    }

    @Test
    void bow_init_Test() {
        Bow bow = new Bow();

        Assertions.assertNotNull(bow);

        Assertions.assertEquals(2000, bow.delay);
        Assertions.assertEquals(60, bow.base_damage);
        Assertions.assertEquals(0, bow.projectile_type);
        Assertions.assertEquals(10, bow.range);
    }
}
