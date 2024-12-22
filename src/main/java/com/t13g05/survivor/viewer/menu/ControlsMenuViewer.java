package com.t13g05.survivor.viewer.menu;

import com.t13g05.survivor.Game;
import com.t13g05.survivor.gui.GUI;
import com.t13g05.survivor.model.menu.ControlsMenu;
import com.t13g05.survivor.model.menu.Entry;
import com.t13g05.survivor.viewer.Viewer;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ControlsMenuViewer extends Viewer<ControlsMenu> {
    public ControlsMenuViewer(ControlsMenu controlsMenu) {
        super(controlsMenu);
    }
    @Override
    public void drawElements(GUI gui) throws IOException{
        gui.clear();
        gui.drawText((Game.width-8)/2,Game.height/10, "Controls", "#FFFFFF");
        drawControls(gui, Arrays.asList("Move UP", "W", "Move DOWN", "S",
                "Move Right", "D", "Move LEFT", "A",
                "Shoot", "P", "Ability", "O"));
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

    private void drawControls(GUI gui, List<String> controls){
        for (int i = 0; i < controls.size(); i++) {
            gui.drawText(Game.width/2-((i%2==0 ? 7 : -7)),
                    Game.height/4+((i%2==0 ? i : (i-1))),
                    controls.get(i), "#FFFFFF");

        }
    }
}
