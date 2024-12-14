package com.t13g05.survivor.model.game.arena;

import com.t13g05.survivor.gui.LanternaGUI;
import com.t13g05.survivor.model.Position;
import com.t13g05.survivor.model.game.element.entity.Survivor;
import com.t13g05.survivor.viewer.game.GameViewer;
import com.t13g05.survivor.viewer.game.SurvivorViewer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;

public class ArenaTest {
    private Arena arena;
    private int width = 20;
    private int height = 20;
    private LanternaGUI lanternaGUI;
    private GameViewer gameViewer;
    private Survivor survivor;
    private SurvivorViewer survivorViewer;

    @BeforeEach
    public void setUp() {
        arena = new Arena(width,height);
        gameViewer = new GameViewer(arena);
        lanternaGUI = Mockito.mock(LanternaGUI.class);
        survivor = arena.getSurvivor();
        survivorViewer = Mockito.mock(SurvivorViewer.class);
    }

    @Test
    public void init_test() throws Exception {
        gameViewer.draw(lanternaGUI);
        survivorViewer.draw(survivor, lanternaGUI);
        Mockito.verify(survivorViewer,times(1)).draw(survivor, lanternaGUI);


        Assertions.assertNotNull(arena);
        Assertions.assertNotNull(arena.getSurvivor());
        Assertions.assertEquals(arena.getHeight(), height);
        Assertions.assertEquals(arena.getWidth(), width);
    }

    @Test
    public void draw_test() throws Exception {
        gameViewer.draw(lanternaGUI);
        Position new_pos = new Position(10,10);
        Survivor new_survivor = new Survivor(new_pos);
        survivorViewer.draw(new_survivor, lanternaGUI);
        Mockito.verify(survivorViewer,times(1)).draw(new_survivor, lanternaGUI);
    }
}
