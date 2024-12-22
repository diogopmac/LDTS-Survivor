package com.t13g05.survivor.viewer;

import com.t13g05.survivor.gui.GUI;
import com.t13g05.survivor.model.Position;
import com.t13g05.survivor.model.game.element.entity.Survivor;
import com.t13g05.survivor.model.game.element.entity.classes.Mage;
import com.t13g05.survivor.model.game.element.entity.classes.Rogue;
import com.t13g05.survivor.model.game.element.entity.classes.Warrior;
import com.t13g05.survivor.viewer.game.SurvivorViewer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class SurvivorViewerTest {
    private SurvivorViewer survivorViewer;
    private GUI gui;
    private Survivor survivor;

    @BeforeEach
    void setUp() {
        survivorViewer = new SurvivorViewer();
        gui = Mockito.mock(GUI.class);
        survivor = Mockito.mock(Survivor.class);
    }

    @Test
    public void draw_test(){
        Position position = new Position(0, 0);
        Mockito.when(survivor.getPosition()).thenReturn(position);
        survivorViewer.draw(survivor,gui);

        if (survivor instanceof Warrior){
            Mockito.verify(gui).drawText(position.x(), position.y(), "£", "#FFD700");
        }
        else if (survivor instanceof Mage){
            Mockito.verify(gui).drawText(position.x(), position.y(), "&", "#FFD700");
        }
        else if (survivor instanceof Rogue){
            Mockito.verify(gui).drawText(position.x(), position.y(), "@", "#FFD700");
        }


    }
}
