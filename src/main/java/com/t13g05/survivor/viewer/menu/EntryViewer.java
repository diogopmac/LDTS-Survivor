package com.t13g05.survivor.viewer.menu;

import com.t13g05.survivor.gui.GUI;
import com.t13g05.survivor.model.menu.Entry;

public class EntryViewer {
    private final TextViewer textViewer;
    public EntryViewer(TextViewer textViewer) {
        this.textViewer = textViewer;
    }

    public void draw(Entry entry, GUI gui, String color) {
        String entryText = switch (entry.getType()){
            case START_GAME -> "Start Game";
            case CONTROLS -> "Controls";
            case OPTIONS -> "Options";
            case QUIT -> "Quit";
        };
        textViewer.draw(entryText, entry.getPosition().x(), entry.getPosition().y(), gui, color);
    }
}
