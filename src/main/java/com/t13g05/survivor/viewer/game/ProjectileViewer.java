package com.t13g05.survivor.viewer.game;

import com.t13g05.survivor.gui.GUI;
import com.t13g05.survivor.model.game.element.Projectile;

public class ProjectileViewer implements ElementViewer<Projectile> {
    @Override
    public void draw(Projectile projectile, GUI gui){
        gui.drawText(projectile.getPosition().x(), projectile.getPosition().y(), "-", "#FF0000");
    }
}
