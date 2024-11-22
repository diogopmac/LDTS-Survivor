package com.t13g05.survivor.model.game.element;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProjectileTest {
    @Test
    public void testConstructor() {
        Projectile projectile = new Projectile();
        Assertions.assertNotNull(projectile);
    }
}
