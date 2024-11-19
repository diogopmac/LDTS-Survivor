package com.t13g05.survivor.gui;

import com.t13g05.survivor.model.Position;

import java.io.IOException;

public interface GUI {
    void drawText(int x, int y, String s, String color);

    void drawSurvivor(Position position);

    void clear();

    void refresh() throws IOException;

    void close() throws IOException;

    enum ACTION {UP, DOWN, LEFT, RIGHT, NONE, QUIT, SELECT}
}
