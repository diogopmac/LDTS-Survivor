import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Arena {
    private int width;
    private int height;
    private Survivor survivor;

    public Arena(int width, int height) {
        this.width = width;
        this.height = height;
        survivor = new Survivor(new Position(width/2, height/2));
    }

    public void draw(TextGraphics graphics) {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#000000"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height),' ');
        survivor.draw(graphics);
    }
}
