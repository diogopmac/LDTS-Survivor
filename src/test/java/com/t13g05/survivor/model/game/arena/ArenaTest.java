package com.t13g05.survivor.model.game.arena;

import com.t13g05.survivor.Game;
import com.t13g05.survivor.GameConfig;
import com.t13g05.survivor.gui.LanternaGUI;
import com.t13g05.survivor.model.Position;
import com.t13g05.survivor.model.game.element.entity.Monster;
import com.t13g05.survivor.model.game.element.entity.Survivor;
import com.t13g05.survivor.viewer.game.GameViewer;
import com.t13g05.survivor.viewer.game.SurvivorViewer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;

public class ArenaTest {
    private Arena arena;
    private final int width = Game.width;
    private final int height = Game.height;
    private LanternaGUI lanternaGUI;
    private GameViewer gameViewer;
    private Survivor survivor;
    private SurvivorViewer survivorViewer;
    private List<Monster> monsters;

    @BeforeEach
    public void setUp() {
        GameConfig gameConfig = GameConfig.getInstance();
        ArenaFactory factory = new ArenaCreator();
        arena = factory.createArena(Game.width,
                Game.height,
                gameConfig.getSelectedClass(),
                gameConfig.getSelectedWeapon());
        gameViewer = new GameViewer(arena);
        lanternaGUI = Mockito.mock(LanternaGUI.class);
        survivor = arena.getSurvivor();
        survivorViewer = Mockito.mock(SurvivorViewer.class);
        monsters = arena.getMonsters();
    }

    @Test
    public void init_test() throws Exception {
        gameViewer.draw(lanternaGUI);
        survivorViewer.draw(survivor, lanternaGUI);
        Mockito.verify(survivorViewer,times(1)).draw(survivor, lanternaGUI);

        Assertions.assertTrue(width > survivor.getPosition().x());
        Assertions.assertTrue(height > survivor.getPosition().y());
        Assertions.assertFalse(monsters.isEmpty());
        Assertions.assertNotNull(monsters);

        Assertions.assertNotNull(arena);
        Assertions.assertNotNull(arena.getSurvivor());
        Assertions.assertEquals(arena.getHeight(), height);
        Assertions.assertEquals(arena.getWidth(), width);
    }

    @Test
    public void draw_test() throws Exception {
        gameViewer.draw(lanternaGUI);
        Position new_pos = new Position(10,10);
        Survivor new_survivor = new Survivor(new_pos, 100, "Sword");
        survivorViewer.draw(new_survivor, lanternaGUI);
        Mockito.verify(survivorViewer,times(1)).draw(new_survivor, lanternaGUI);
    }
}
