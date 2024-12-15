package com.t13g05.survivor.model.game.arena;

import com.t13g05.survivor.model.Position;
import com.t13g05.survivor.model.game.element.entity.Monster;
import com.t13g05.survivor.model.game.element.entity.Survivor;

import java.util.ArrayList;
import java.util.List;

public class ArenaCreator implements ArenaFactory{
    @Override
    public Arena createArena(int width, int height, String selectedClass, String selectedWeapon){
        Survivor survivor = createSurvivor(selectedClass, selectedWeapon, width, height);
        Arena arena = new Arena(width, height);

        arena.setSurvivor(survivor);

        List<Monster> monsters = createMonsters();
        arena.setMonsters(monsters);
        return arena;
    }

    private Survivor createSurvivor(String selectedClass, String selectedWeapon, int width, int height){
        Position position = new Position(width/2, height/2);

        return switch (selectedClass) {
            case "Warrior" -> new Survivor(position, 150);
            case "Mage" -> new Survivor(position, 90);
            case "Rogue" -> new Survivor(position, 110);
            case "Paladin" -> new Survivor(position, 200);
            default -> null;
        };
    }

    private List<Monster> createMonsters(){
        List<Monster> monsters = new ArrayList<>();
        monsters.add(new Monster(new Position(10,5)));
        monsters.add(new Monster(new Position(30,10)));
        monsters.add(new Monster(new Position(2,30)));
        monsters.add(new Monster(new Position(50,30)));
        monsters.add(new Monster(new Position(60,3)));
        return monsters;
    }
}
