package pt.up.fe.survivor1305.model.game.entity;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import pt.up.fe.survivor1305.model.Position;

public class Survivor {
    protected Position position;

    public Survivor(Position position) {
        this.position = position;
    }

    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(position.x(), position.y()), "X");
    }
}
