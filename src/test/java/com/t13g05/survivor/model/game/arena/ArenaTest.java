package com.t13g05.survivor.model.game.arena;

import com.t13g05.survivor.gui.LanternaGUI;
import com.t13g05.survivor.model.Position;
import com.t13g05.survivor.viewer.game.GameViewer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.times;

public class ArenaTest {
    private Arena arena;
    private int widht = 20;
    private int height = 20;
    private LanternaGUI lanternaGUI;
    private GameViewer gameViewer;

    @BeforeEach
    public void setUp() {
        arena = new Arena(widht,height);
        gameViewer = new GameViewer(arena);
        lanternaGUI = Mockito.mock(LanternaGUI.class);
    }

    @Test
    public void init_test() throws Exception {
        gameViewer.draw(lanternaGUI);
        Position position = new Position(widht/2,height/2);
        Mockito.verify(lanternaGUI,times(1)).drawSurvivor(position);

        Assertions.assertNotNull(arena);
        Assertions.assertNotNull(arena.getSurvivor());
        Assertions.assertEquals(arena.getHeight(), height);
        Assertions.assertEquals(arena.getWidth(), widht);
    }

    @Test
    public void draw_test() throws Exception {
        gameViewer.draw(lanternaGUI);
        Mockito.verify(lanternaGUI,times(1)).drawSurvivor(Mockito.any(Position.class));
    }
}
