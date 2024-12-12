package com.t13g05.survivor.viewer.menu;

import com.t13g05.survivor.gui.GUI;

public interface TextViewer {
    void draw(char Char, int x, int y, GUI gui, String color);
    void draw(String string, int x, int y, GUI gui, String color);
}
