package com.t13g05.survivor.model.game.menu;

import com.t13g05.survivor.model.Position;
import com.t13g05.survivor.model.menu.Entry;
import com.t13g05.survivor.model.menu.Type;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class EntryTest {
    private Entry entry;

    @Test
    public void createEntry() {
        entry = new Entry(new Position(10,10), Type.OPTIONS);
        Assertions.assertNotNull(entry);
    }
}
