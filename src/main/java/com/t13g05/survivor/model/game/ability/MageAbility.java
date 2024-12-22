package com.t13g05.survivor.model.game.ability;

import com.t13g05.survivor.model.game.element.entity.Survivor;

public class MageAbility extends Ability {
    private final long duration;
    private long endTime;

    public MageAbility(long duration, long cooldown) {
        super(cooldown);
        this.duration = duration;
    }

    @Override
    public void use(Survivor survivor) {
        if (onCooldown()) return;

        startCooldown();
        endTime = System.currentTimeMillis() + duration;
        survivor.setShield(true);
        survivor.setPreventLevelUp(true);
    }

    @Override
    public void update(Survivor survivor, long time){
        if (System.currentTimeMillis() > endTime && survivor.isShielded()){
            survivor.setShield(false);
            survivor.setPreventLevelUp(false);
        }
    }
}
