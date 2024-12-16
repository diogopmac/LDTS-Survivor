package com.t13g05.survivor.viewer.menu;

import com.t13g05.survivor.Game;
import com.t13g05.survivor.gui.GUI;
import com.t13g05.survivor.model.menu.Entry;
import com.t13g05.survivor.model.menu.OptionsEntry;
import com.t13g05.survivor.model.menu.OptionsMenu;
import com.t13g05.survivor.viewer.Viewer;

import java.io.IOException;
import java.util.List;

public class OptionsMenuViewer extends Viewer<OptionsMenu> {
    public OptionsMenuViewer(OptionsMenu optionsMenu) {
        super(optionsMenu);
    }

    @Override
protected void drawElements(GUI gui) throws IOException {
        gui.clear();
        gui.drawText(Game.width / 2 - 8, Game.height / 10, "Settings ", "#FFFFFF");
        gui.drawText(Game.width / 2 - 12, Game.height / 3, "Class ", "#FFFFFF");
        gui.drawText(Game.width / 2 - 12, Game.height / 3+5, "Weapon ", "#FFFFFF");
        drawEntries(gui, getModel().getEntries());
        gui.refresh();

    }

    private void drawEntries(GUI gui, List<Entry> entries){
        int i = 0;
        for (Entry entry : entries) {
            if (entry instanceof OptionsEntry optionsEntry) {
                gui.drawText(optionsEntry.getPosition().x(),
                        optionsEntry.getPosition().y(),
                        optionsEntry.getSelectedOption().getText(),
                        getModel().isSelected(i) ? "#FFFF00" : "#FFFFFF");
            } else {
                gui.drawText(
                        entry.getPosition().x(),
                        entry.getPosition().y(),
                        entry.getType().getText(),
                        getModel().isSelected(i) ? "#FFFF00" : "#FFFFFF");

            }
            i++;
        }

    }
}
