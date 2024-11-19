package com.t13g05.survivor;

import java.io.IOException;

public class Application {
    public static void main(String[] args) {
        Game game = new Game();
        try {
            game.run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
