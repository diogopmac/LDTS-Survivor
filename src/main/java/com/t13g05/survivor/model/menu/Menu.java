package com.t13g05.survivor.model.menu;

import java.util.List;

public abstract class Menu {
    private final List<Entry> entries;
    private int entry = 0;

    public Menu() {
        this.entries = createEntries();
    }

    protected abstract List<Entry> createEntries();

    public List<Entry> getEntries() {
        return entries;
    }
    public Entry getEntry() {
        return entries.get(entry);
    }
    public int getEntryCount() {
        return entries.size();
    }
    public void moveDown(){
        entry++;
        entry %= getEntryCount();
    }
    public void moveUp(){
        entry+= getEntryCount()-1;
        entry %= getEntryCount();
    }
}
