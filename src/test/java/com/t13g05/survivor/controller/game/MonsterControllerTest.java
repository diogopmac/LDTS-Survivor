package com.t13g05.survivor.controller.game;

import com.t13g05.survivor.Game;
import com.t13g05.survivor.model.Position;
import com.t13g05.survivor.model.game.ability.Ability;
import com.t13g05.survivor.model.game.arena.Arena;
import com.t13g05.survivor.model.game.element.entity.Monster;
import com.t13g05.survivor.model.game.element.entity.Survivor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MonsterControllerTest {
    private Arena arena;
    private MonsterController monsterController;
    private Survivor survivor;
    private Monster monster;
    private Game game;
    private Ability ability;

    @BeforeEach
    public void setUp() {
        game = Mockito.mock(Game.class);
        ability = Mockito.mock(Ability.class);

        arena = new Arena(70,45);
        survivor = new Survivor(new Position(5,5), 100, "Bow", ability);
        monster = new Monster(new Position(2,5), 10, 10);

        arena.setSurvivor(survivor);
        arena.setMonsters(new ArrayList<>(List.of(monster)));

        monsterController = new MonsterController(arena);
    }

    @Test
    public void moveTowardsSurvivorX(){
        monsterController.step(game, Set.of(), System.currentTimeMillis());
        Assertions.assertEquals(new Position(3,5), monster.getPosition());
    }

    @Test
    public void collisionTest(){
        monster.setPosition(new Position(4,5));
        survivor.setShield(false);
        int health = survivor.getHealth();

        monsterController.step(game, Set.of(), System.currentTimeMillis());
        Assertions.assertEquals(90, survivor.getHealth());
        Assertions.assertEquals(health-monster.getDamage(), survivor.getHealth());
    }

    @Test
    public void collisionWithShieldTest(){
        monster.setPosition(new Position(4,5));
        survivor.setShield(true);
        int health = survivor.getHealth();

        monsterController.step(game, Set.of(), System.currentTimeMillis());
        Assertions.assertEquals(100, survivor.getHealth());
        Assertions.assertEquals(health, survivor.getHealth());
    }


    @Test
    public void yPreferenceTest(){
        monster.setPosition(new Position(4,4));

        monsterController.step(game, Set.of(), System.currentTimeMillis());
        Assertions.assertEquals(new Position(4,5), monster.getPosition());
    }

    @Test
    public void moveTowardsSurvivorY(){
        monster.setPosition(new Position(5,2));

        monsterController.step(game, Set.of(), System.currentTimeMillis());
        Assertions.assertEquals(new Position(5,3), monster.getPosition());
    }

    @Test
    public void monsterSpawnerTest(){
        monsterController.step(game, Set.of(), System.currentTimeMillis());

        List<Monster> monsters = arena.getMonsters();
        Assertions.assertFalse(monsters.isEmpty());

        for (Monster monster : monsters) {
            Assertions.assertNotNull(monster);
        }
    }

    @Test
    public void lastMovementTest(){
        long startTime = System.currentTimeMillis();
        monsterController.step(game, Set.of(), System.currentTimeMillis());
        List<Monster> monsters = arena.getMonsters();

        monsterController.step(game, Set.of(), System.currentTimeMillis()+200);
        Assertions.assertEquals(monsters.size(), arena.getMonsters().size());
    }

    @Test
    public void spawnTest(){
        for(int i = 0; i<11; i++)survivor.levelUp();
        long currentTime = System.currentTimeMillis();
        List<Monster> initialMonsters = new ArrayList<>(arena.getMonsters());

        for (int i = 0; i < 100; i++) monsterController.step(game, Set.of(), currentTime + (i + 1) * 1000);

        Assertions.assertTrue(arena.getMonsters().size() > initialMonsters.size());
    }


}
