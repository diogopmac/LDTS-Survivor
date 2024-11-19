package pt.up.fe.survivor1305.model.game.entity;

import pt.up.fe.survivor1305.model.Position;

public class Entity {
    protected Position position;

    public Entity(int x, int y) {
        this.position = new Position(x, y);
    }

    public Position getPosition() { return position; }
    public void setPosition(Position position) { this.position = position; }
}
