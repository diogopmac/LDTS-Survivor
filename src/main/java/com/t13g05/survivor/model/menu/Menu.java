package com.t13g05.survivor.model.menu;

import java.util.List;

public abstract class Menu {
    private final List<Entry> entries;
    private int currentEntry = 0;

    public Menu() {
        this.entries = createEntries();
    }

    protected abstract List<Entry> createEntries();

    public List<Entry> getEntries() {
        return entries;
    }

    public Entry getEntry() {
        return entries.get(currentEntry);
    }

    public int getEntryCount() {
        return this.entries.size();
    }

    public void moveDown(){
        currentEntry++;
        currentEntry %= getEntryCount();
    }

    public void moveUp(){
        currentEntry+= getEntryCount()-1;
        currentEntry %= getEntryCount();
    }

    public void moveRight(){
        Entry current = getEntry();
        if (current instanceof OptionsEntry){
            ((OptionsEntry) current).nextEntry();
        }
    }

    public void moveLeft(){
        Entry current = getEntry();
        if (current instanceof OptionsEntry){
            ((OptionsEntry) current).previousEntry();
        }
    }

    public boolean isSelected(int i){
        return currentEntry == i;
    }
}
