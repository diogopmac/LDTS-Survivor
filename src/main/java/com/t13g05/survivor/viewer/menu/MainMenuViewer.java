package com.t13g05.survivor.viewer.menu;

import com.t13g05.survivor.Game;
import com.t13g05.survivor.gui.GUI;
import com.t13g05.survivor.model.menu.Entry;
import com.t13g05.survivor.model.menu.MainMenu;
import com.t13g05.survivor.viewer.Viewer;

import java.io.IOException;
import java.util.List;

public class MainMenuViewer extends Viewer<MainMenu> {

    public MainMenuViewer(MainMenu mainMenu) {
        super(mainMenu);
    }

    @Override
    public void drawElements(GUI gui) throws IOException {
        gui.clear();
        gui.drawText((Game.width-8)/2,Game.height/10, "Survivor", "#FFFFFF");
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
