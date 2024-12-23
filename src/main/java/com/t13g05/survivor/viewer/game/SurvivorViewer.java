package com.t13g05.survivor.viewer.game;

import com.t13g05.survivor.gui.GUI;
import com.t13g05.survivor.model.game.element.entity.Survivor;
import com.t13g05.survivor.model.game.element.entity.classes.Mage;
import com.t13g05.survivor.model.game.element.entity.classes.Rogue;
import com.t13g05.survivor.model.game.element.entity.classes.Warrior;

public class SurvivorViewer implements ElementViewer<Survivor> {
    @Override
    public void draw(Survivor survivor, GUI gui) {
        gui.drawText(survivor.getPosition().x(), survivor.getPosition().y(), survivor.getCharacter(),
                (survivor.getAbility().isActive()) ? survivor.getColor() : "#FFD700");
    }
}