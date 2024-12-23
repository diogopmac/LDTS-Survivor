package com.t13g05.survivor.model.game.element.entity.classes;

import com.t13g05.survivor.model.Position;
import com.t13g05.survivor.model.game.ability.RogueAbility;
import com.t13g05.survivor.model.game.element.entity.Survivor;

public class Rogue extends Survivor {
    public Rogue(Position position, String weapon) {
        super(position, 110, weapon, new RogueAbility(6, 5000));
        character = "@";
    }
}
