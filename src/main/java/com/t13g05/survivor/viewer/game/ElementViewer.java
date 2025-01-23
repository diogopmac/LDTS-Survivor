package com.t13g05.survivor.viewer.game;

import com.t13g05.survivor.gui.GUI;
import com.t13g05.survivor.model.game.element.Element;

public interface ElementViewer<T extends Element> {
    void draw(T element, GUI gui);
}
