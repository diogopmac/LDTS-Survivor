package com.t13g05.survivor.model.game.arena;

import com.t13g05.survivor.model.Position;
import com.t13g05.survivor.model.game.element.entity.Survivor;
import com.t13g05.survivor.model.game.element.entity.classes.Mage;
import com.t13g05.survivor.model.game.element.entity.classes.Rogue;
import com.t13g05.survivor.model.game.element.entity.classes.Warrior;

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

        return switch (selectedClass) {
            case "Warrior" -> new Warrior(position, 150, selectedWeapon);
            case "Mage" -> new Mage(position, 90, selectedWeapon);
            case "Rogue" -> new Rogue(position, 110, selectedWeapon);
            default -> null;
        };
    }
}
