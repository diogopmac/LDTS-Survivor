package com.t13g05.survivor.viewer.game;

import com.t13g05.survivor.gui.GUI;
import com.t13g05.survivor.model.game.element.entity.Monster;

public class MonsterViewer implements ElementViewer<Monster> {
    @Override
    public void draw(Monster monster, GUI gui){
        gui.drawText(monster.getPosition().x(), monster.getPosition().y(), "M", "#FF0000");
    }
}
