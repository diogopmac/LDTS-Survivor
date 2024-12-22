package com.t13g05.survivor.model.game.ability;

import com.t13g05.survivor.Game;
import com.t13g05.survivor.model.Position;
import com.t13g05.survivor.model.game.element.entity.Survivor;

public class RogueAbility extends Ability {
    private int width = Game.width;
    private int height = Game.height;
    private final int dist;
    public RogueAbility(int dist, int cooldown) {
        super(cooldown);
        this.dist = dist;
    }
    @Override
    public void use(Survivor survivor) {
        if (onCooldown()) return;

        startCooldown();
        Position direction = survivor.getDirection();
        Position position = survivor.getPosition();
        int x = position.x() + direction.x()*dist;
        int y = position.y() + direction.y()*dist;

        if (x < 0){
            x = 1;
        }
        if (y < 0){
            y = 1;
        }
        if (x > width-1){
            x = width-1;
        }
        if (y > height-1){
            y = height-1;
        }

        survivor.setPosition(new Position(x, y));
    }

    @Override
    public void update(Survivor survivor, long time){}
}
