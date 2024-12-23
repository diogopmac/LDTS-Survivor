package com.t13g05.survivor;

import com.t13g05.survivor.gui.LanternaGUI;
import com.t13g05.survivor.model.menu.MainMenu;
import com.t13g05.survivor.state.MainMenuState;
import com.t13g05.survivor.state.State;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Game {
    private final LanternaGUI gui;
    private State<?> state;
    private State<?> previousState;
    public static final int width = 70;
    public static final int height = 45;

    public Game() throws IOException, URISyntaxException, FontFormatException {
        this.gui = new LanternaGUI(width,height, "SURVIVOR");
        this.state = new MainMenuState(new MainMenu());
        this.previousState = null;
    }

    public void run() throws IOException {
        int FPS = 30;
        int frameTime = 1000 / FPS;

        while (this.state != null) {
            long startTime = System.currentTimeMillis();

            state.step(this, gui, startTime);

            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;

            try {
                if (sleepTime > 0) Thread.sleep(sleepTime);
            } catch (InterruptedException ignored) {};
        }

        gui.close();
    }

    public static void main(String[] args) throws IOException, URISyntaxException, FontFormatException {
        Game game = new Game();
        try {
            game.run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public State<?> getState() {
        return state;
    }

    public void setState(State<?> state) {
        this.state = state;
    }

    public void saveState() {
        previousState = state;
    }

    public void loadPreviousState() {
        state = previousState;
    }
}
