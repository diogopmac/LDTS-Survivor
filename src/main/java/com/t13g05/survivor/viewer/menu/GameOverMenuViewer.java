package com.t13g05.survivor.viewer.menu;

import com.t13g05.survivor.Game;
import com.t13g05.survivor.gui.GUI;
import com.t13g05.survivor.model.menu.Entry;
import com.t13g05.survivor.model.menu.GameOverMenu;
import com.t13g05.survivor.viewer.Viewer;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class GameOverMenuViewer extends Viewer<GameOverMenu> {
    public GameOverMenuViewer(GameOverMenu gameOverMenu) {
        super(gameOverMenu);
    }

    @Override
    public void drawElements(GUI gui) throws IOException {
        gui.clear();
        gui.drawText((Game.width-9)/2,Game.height/10+3, "Game Over", "#FFFFFF");
        drawEntries(gui, getModel().getEntries(), Arrays.asList("Retry", "Back to Main Menu"));
        gui.refresh();
    }

    private void drawEntries(GUI gui, List<Entry> entries, List<String> options) {
        int i = 0;

        for (Entry entry : entries) {
            int offset = (Game.width-options.get(i).length())/2;
            gui.drawText(
                    offset,
                    entry.getPosition().y()+3,
                    options.get(i),
                    getModel().isSelected(i) ? "#FFFF00" : "#FFFFFF");
            i++;
        }
    }
}
