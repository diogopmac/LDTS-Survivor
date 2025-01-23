package com.t13g05.survivor.gui;

import java.io.IOException;
import java.util.Set;

public interface GUI {
    void drawText(int x, int y, String s, String color);

    void clear();

    void refresh() throws IOException;

    void close() throws IOException;

    Set<Action> getActions();
}
