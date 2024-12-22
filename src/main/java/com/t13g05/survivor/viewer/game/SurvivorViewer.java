package com.t13g05.survivor.viewer.game;

import com.t13g05.survivor.gui.GUI;
import com.t13g05.survivor.model.game.element.entity.Survivor;
import com.t13g05.survivor.model.game.element.entity.classes.Mage;
import com.t13g05.survivor.model.game.element.entity.classes.Rogue;
import com.t13g05.survivor.model.game.element.entity.classes.Warrior;

public class SurvivorViewer implements ElementViewer<Survivor> {
    @Override
    public void draw(Survivor survivor, GUI gui) {
        if (survivor instanceof Warrior){
            gui.drawText(survivor.getPosition().x(), survivor.getPosition().y(), "£",
                    (survivor.isShielded()) ? "#0000FF" : "#FFD700");
        }
        else if (survivor instanceof Mage){
            gui.drawText(survivor.getPosition().x(), survivor.getPosition().y(), "&",
                    (survivor.isShielded()) ? "#0000FF" : "#FFD700");
        }
        else if (survivor instanceof Rogue){
            gui.drawText(survivor.getPosition().x(), survivor.getPosition().y(), "@",
                    (survivor.isShielded()) ? "#0000FF" : "#FFD700");
        }

    }
}