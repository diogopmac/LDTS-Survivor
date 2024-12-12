package com.t13g05.survivor.model.menu;

import com.t13g05.survivor.model.Position;

public class Entry {
    private final Position position;
    private final Type type;

    public Entry(Position position, Type type) {
        this.position = position;
        this.type = type;
    }

    public Position getPosition() {
        return position;
    }

    public Type getType() {
        return type;
    }
}
