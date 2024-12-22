package com.t13g05.survivor.model.game.ability;

public abstract class Ability implements AbilityCommand {
    protected long cooldown;
    protected long lastUsed = 0;

    public Ability(long cooldown) {
        this.cooldown = cooldown;
    }
    @Override
    public boolean onCooldown(){
        return System.currentTimeMillis() - lastUsed < cooldown;
    }

    protected void startCooldown(){
        lastUsed = System.currentTimeMillis();
    }

    public long getCooldown() {
        long now = System.currentTimeMillis()-lastUsed;
        if(now > cooldown){
            return 0;
        }
        else return (cooldown - now)/1000 +1 ;
    }

}
