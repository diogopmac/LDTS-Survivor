package com.t13g05.survivor.model.game.element;

import com.t13g05.survivor.model.Position;

public class Element {
    protected Position position;
    
    protected Element() {
        position = new Position(0,0);
    }

    public Element(Position position) {
        this.position = position;
    }

    public Position getPosition() { return position; }
    public void setPosition(Position position) { this.position = position; }
}
