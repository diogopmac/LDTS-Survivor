package com.t13g05.survivor.model.game.ability;

import com.t13g05.survivor.model.game.element.entity.Survivor;

public class WarriorAbility implements Ability {
    public static final int boost = 2;
    public static final int duration = 5000;
    @Override
    public void use(Survivor survivor) {
        int damage = survivor.getDamage();
        survivor.upDamage(damage*boost);

        new Thread(
                () ->
                {
            try{
                Thread.sleep(duration);
            }
            catch (InterruptedException e) {}
            survivor.damage(damage);
        }).start();
    }
}
