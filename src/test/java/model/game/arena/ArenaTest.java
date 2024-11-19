package model.game.arena;

import com.t13g05.survivor.gui.LanternaGUI;
import com.t13g05.survivor.model.Position;
import com.t13g05.survivor.model.game.arena.Arena;
import com.t13g05.survivor.model.game.entity.Survivor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.times;

public class ArenaTest {
    private Arena arena;
    private int widht = 20;
    private int height = 20;
    private LanternaGUI lanternaGUI;

    @BeforeEach
    public void setUp() {
        arena = new Arena(widht,height);
        lanternaGUI = Mockito.mock(LanternaGUI.class);
    }

    @Test
    public void init_test(){
        arena.draw(lanternaGUI);
        Position position = new Position(widht/2,height/2);
        Mockito.verify(lanternaGUI,times(1)).drawSurvivor(position);
    }

    @Test
    public void draw_test(){
        arena.draw(lanternaGUI);
        Mockito.verify(lanternaGUI,times(1)).drawSurvivor(Mockito.any(Position.class));
    }
}
