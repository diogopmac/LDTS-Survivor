package com.t13g05.survivor.viewer.menu;

import com.t13g05.survivor.Game;
import com.t13g05.survivor.gui.GUI;
import com.t13g05.survivor.model.menu.Entry;
import com.t13g05.survivor.model.menu.SettingsEntry;
import com.t13g05.survivor.model.menu.SettingsMenu;
import com.t13g05.survivor.viewer.Viewer;

import java.io.IOException;
import java.util.List;

public class SettingsMenuViewer extends Viewer<SettingsMenu> {
    public SettingsMenuViewer(SettingsMenu settingsMenu) {
        super(settingsMenu);
    }

    @Override
protected void drawElements(GUI gui) throws IOException {
        gui.clear();
        gui.drawText((Game.width-8)/2, Game.height / 10, "Settings ", "#FFFFFF");
        gui.drawText((Game.width-6)/2-5, Game.height / 3, "Class ", "#FFFFFF");
        gui.drawText((Game.width-7)/2-4, Game.height / 3+5, "Weapon ", "#FFFFFF");


        drawEntries(gui, getModel().getEntries());
        gui.refresh();

    }

    private void drawEntries(GUI gui, List<Entry> entries){
        int i = 0;
        for (Entry entry : entries) {
            if (entry instanceof SettingsEntry settingsEntry) {
                gui.drawText(settingsEntry.getPosition().x(),
                        settingsEntry.getPosition().y(),
                        settingsEntry.getSelectedOption().getText(),
                        getModel().isSelected(i) ? "#FFFF00" : "#FFFFFF");
            } else {
                gui.drawText(
                        entry.getPosition().x(),
                        entry.getPosition().y(),
                        (i != 2) ? entry.getType().getText() : "Apply",
                        getModel().isSelected(i) ? "#FFFF00" : "#FFFFFF");

            }
            i++;
        }

    }
}
