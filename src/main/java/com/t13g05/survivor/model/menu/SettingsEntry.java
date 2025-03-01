package com.t13g05.survivor.model.menu;

import com.t13g05.survivor.model.Position;

import java.util.List;

public class SettingsEntry extends Entry {
    private final List<Type> options;
    private int currentEntryIndex = 0;

    public SettingsEntry(Position position, Type type, List<Type> options) {
        super(position, type);
        this.options = options;
    }

    public void nextEntry() {
        currentEntryIndex++;
        currentEntryIndex %= getEntryCount();
    }

    public void previousEntry() {
        currentEntryIndex+= getEntryCount() -1 ;
        currentEntryIndex %= getEntryCount();
    }

    public List<Type> getOptions() {
        return options;
    }

    public int getEntryCount() {
        return options.size();
    }

    public Type getSelectedOption() {
        return options.get(currentEntryIndex);
    }
}
