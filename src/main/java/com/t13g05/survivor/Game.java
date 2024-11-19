package com.t13g05.survivor;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import com.t13g05.survivor.gui.LanternaGUI;
import com.t13g05.survivor.model.game.arena.Arena;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class Game {
    private Arena arena;
    private final LanternaGUI gui;
    public Game() throws IOException, URISyntaxException, FontFormatException {
        this.gui = new LanternaGUI(70,45);
        arena = new Arena(70, 45);
    }

    public void draw() throws IOException {
        gui.clear();
        arena.draw(gui);
        gui.refresh();
    }

    public void run() throws IOException {
        while (true) {
            draw();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) throws IOException, URISyntaxException, FontFormatException {
        Game game = new Game();
        try {
            game.run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
