package com.t13g05.survivor.viewer.menu;

import com.t13g05.survivor.gui.GUI;
import com.t13g05.survivor.model.menu.Entry;
import com.t13g05.survivor.model.menu.MainMenu;
import com.t13g05.survivor.viewer.Viewer;

import java.util.List;

public class MainMenuViewer extends Viewer<MainMenu> {
    public MainMenuViewer(MainMenu mainMenu) {
        super(mainMenu);
    }

    @Override
    public void drawElements(GUI gui){
        gui.drawText(5,5, "Survivor", "#FFFFFF");


    }

    private void drawEntries(GUI gui, List<Entry> entries){
        for (Entry entry : entries) {
            //todo complete
        }
    }
}
