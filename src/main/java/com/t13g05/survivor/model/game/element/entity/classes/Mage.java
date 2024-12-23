package com.t13g05.survivor.model.game.element.entity.classes;

import com.t13g05.survivor.model.Position;
import com.t13g05.survivor.model.game.ability.MageAbility;
import com.t13g05.survivor.model.game.element.entity.Survivor;

public class Mage extends Survivor {
    public Mage(Position position, int health, String weapon) {
        super(position, health, weapon, new MageAbility(7000, 30000));
        color = "#0000FF";
        character = "&";
    }
}
