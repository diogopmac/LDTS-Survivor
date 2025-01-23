package com.t13g05.survivor.model.game.arena;

public interface ArenaFactory {
    Arena createArena(int width, int height, String selectedClass, String selectedWeapon);
}
