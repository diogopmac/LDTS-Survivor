package com.t13g05.survivor.viewer.game;

import com.t13g05.survivor.gui.GUI;
import com.t13g05.survivor.model.Position;
import com.t13g05.survivor.model.game.element.entity.Monster;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MonsterViewerTest {
    private MonsterViewer monsterViewer;
    private GUI gui;
    private Monster monster;

    @BeforeEach
    void setUp() {
        monsterViewer = new MonsterViewer();
        gui = Mockito.mock(GUI.class);
        monster = Mockito.mock(Monster.class);
    }

    @Test
    public void draw_test(){
        Position position = new Position(10, 10);
        Mockito.when(monster.getPosition()).thenReturn(position);
        monsterViewer.draw(monster,gui);
        
        Mockito.verify(gui).drawText(monster.getPosition().x(), monster.getPosition().y(), "M", "#FF0000");

    }
}
