package com.t13g05.survivor.model.game.element.entity.classes;

import com.t13g05.survivor.model.Position;
import com.t13g05.survivor.model.game.ability.RogueAbility;
import com.t13g05.survivor.model.game.element.entity.Survivor;

public class Rogue extends Survivor {
    public Rogue(Position position, int health, String weapon) {
        super(position, health, weapon, new RogueAbility(6, 15000));
        character = "@";
    }
}
