package com.t13g05.survivor.controller.game;

import com.t13g05.survivor.Game;
import com.t13g05.survivor.model.Position;
import com.t13g05.survivor.model.game.ability.Ability;
import com.t13g05.survivor.model.game.arena.Arena;
import com.t13g05.survivor.model.game.element.Projectile;
import com.t13g05.survivor.model.game.element.entity.Monster;
import com.t13g05.survivor.model.game.element.entity.Survivor;
import com.t13g05.survivor.model.weapon.Weapon;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ProjectileControllerTest {
    private Arena arena;
    private ProjectileController projectileController;
    private Survivor survivor;
    private Monster monster;
    private Projectile projectile;
    private Game game;
    private Weapon weapon;
    private Ability ability;

    @BeforeEach
    public void setUp() {
        weapon = Mockito.mock(Weapon.class);
        game = Mockito.mock(Game.class);
        ability = Mockito.mock(Ability.class);

        arena = new Arena(Game.width, Game.height);
        survivor = new Survivor(new Position(10,10), 100, "Bow", ability);
        monster = new Monster(new Position(3,3), 10, 10);

        Mockito.when(weapon.getBaseDamage()).thenReturn(20);
        Mockito.when(weapon.getRange()).thenReturn(20);

        projectile = new Projectile(new Position(2,3), new Position(1,0), weapon);

        arena.setMonsters(new ArrayList<>(List.of(monster)));
        arena.setProjectiles(new ArrayList<>(List.of(projectile)));
        arena.setSurvivor(survivor);

        projectileController = new ProjectileController(arena);
    }

    @Test
    public void movementTest(){
        projectileController.step(game, Set.of(), System.currentTimeMillis());
        Assertions.assertEquals(new Position(3,3), projectile.getPosition());
    }

    @Test
    public void hitAndKillTest(){
        projectileController.step(game, Set.of(), System.currentTimeMillis());
        Assertions.assertEquals(new Position(3,3), projectile.getPosition());

        Assertions.assertEquals(0, monster.getHealth());
    }

    @Test
    public void hitAndNotKillTest(){
        int health = monster.getHealth();
        Mockito.when(weapon.getBaseDamage()).thenReturn(5);

        projectileController.step(game, Set.of(), System.currentTimeMillis());
        Assertions.assertEquals(new Position(3,3), projectile.getPosition());
        Assertions.assertEquals(health-5, monster.getHealth());
    }

    @Test
    public void maxRangeTest(){
        Mockito.when(weapon.getRange()).thenReturn(2);
        projectileController.step(game, Set.of(), System.currentTimeMillis());
        projectileController.step(game, Set.of(), System.currentTimeMillis());

        Assertions.assertTrue(arena.getProjectiles().isEmpty());
    }

    @Test
    public void giveXPTest(){
        int xpInit = survivor.getExperience();

        projectileController.step(game, Set.of(), System.currentTimeMillis());

        Assertions.assertTrue(survivor.getExperience() > xpInit);
    }
}
