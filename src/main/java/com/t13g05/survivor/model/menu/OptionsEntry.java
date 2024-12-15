package com.t13g05.survivor.model.menu;

import com.t13g05.survivor.model.Position;

import java.util.List;

public class OptionsEntry extends Entry {
    private final List<Type> options;
    private int currentEntryIndex = 0;

    public OptionsEntry(Position position, Type type, List<Type> options) {
        super(position, type);
        this.options = options;
    }

    public Type getSelectedOption() {
        return options.get(currentEntryIndex);
    }
    public void nextEntry() {
        currentEntryIndex++;
        currentEntryIndex %= options.size();
    }
    public void previousEntry() {
        currentEntryIndex--;
        currentEntryIndex %= options.size();
    }
}
