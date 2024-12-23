package com.t13g05.survivor.viewer.menu;

import com.t13g05.survivor.Game;
import com.t13g05.survivor.gui.GUI;
import com.t13g05.survivor.model.menu.Entry;
import com.t13g05.survivor.model.menu.PauseMenu;
import com.t13g05.survivor.viewer.Viewer;

import java.io.IOException;
import java.util.List;

public class PauseMenuViewer extends Viewer<PauseMenu> {
    public PauseMenuViewer(PauseMenu pauseMenu) {
        super(pauseMenu);
    }

    @Override
    public void drawElements(GUI gui) throws IOException {
        gui.clear();
        gui.drawText((Game.width-5)/2,Game.height/10, "Pause", "#FFFFFF");
        drawEntries(gui, getModel().getEntries());
        gui.refresh();
    }

    private void drawEntries(GUI gui, List<Entry> entries){
        int i = 0;
        for (Entry entry : entries) {
            gui.drawText(
                    entry.getPosition().x(),
                    entry.getPosition().y(),
                    entry.getType().getText(),
                    getModel().isSelected(i) ? "#FFFF00" : "#FFFFFF" );
            i++;
        }
    }
}
