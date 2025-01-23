package com.t13g05.survivor.model.game.arena;

import com.t13g05.survivor.model.Position;
import com.t13g05.survivor.model.game.element.entity.Survivor;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ArenaCreator implements ArenaFactory {
    @Override
    public Arena createArena(int width, int height, String selectedClass, String selectedWeapon){
        Survivor survivor = createSurvivor(selectedClass, selectedWeapon, width, height);
        Arena arena = new Arena(width, height);

        arena.setSurvivor(survivor);

        return arena;
    }

    private Survivor createSurvivor(String selectedClass, String selectedWeapon, int width, int height){
        Position position = new Position(width/2, height/2);

        try {
            Constructor<?> c = Class.forName("com.t13g05.survivor.model.game.element.entity.classes." + selectedClass)
                    .getConstructor(Position.class, String.class);
            return (Survivor) c.newInstance(position, selectedWeapon);
        } catch (ClassNotFoundException | InvocationTargetException | NoSuchMethodException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
