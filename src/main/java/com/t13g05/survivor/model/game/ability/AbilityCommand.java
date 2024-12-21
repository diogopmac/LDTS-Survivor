package com.t13g05.survivor.model.game.ability;

import com.t13g05.survivor.model.game.element.entity.Survivor;

public interface AbilityCommand {
    void use(Survivor survivor);
    void update(Survivor survivor, long time);
    boolean onCooldown();
}
