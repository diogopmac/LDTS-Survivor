package com.t13g05.survivor.gui;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFrame;
import com.t13g05.survivor.model.Position;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

public class LanternaGUI implements GUI{
    private final Screen screen;
    private Set<ACTION> actionSet = new HashSet<ACTION>();
    public LanternaGUI(Screen screen) {
        this.screen = screen;
    }

    public LanternaGUI(int width, int height) throws IOException, FontFormatException, URISyntaxException {
        AWTTerminalFontConfiguration fontConfig = getFontConfiguration();
        Terminal terminal = createTerminal(width, height, fontConfig);
        this.screen = createScreen(terminal);

        ((AWTTerminalFrame)terminal).getComponent(0).addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                ACTION action = processAction(e);
                actionSet.add(action);
            }
            @Override
            public void keyReleased(KeyEvent e) {
                ACTION action = processAction(e);
                actionSet.remove(action);
            }
        });
    }


    public ACTION processAction(KeyEvent e) {
        int keyCode = e.getKeyCode();

        if (keyCode == 27 /* ESCAPE */) return ACTION.QUIT;

        if (keyCode == 37 /* ARROW_LEFT */) return ACTION.LEFT;
        if (keyCode == 38 /* ARROW_UP */) return ACTION.UP;
        if (keyCode == 39 /* ARROW_RIGHT */) return ACTION.RIGHT;
        if (keyCode == 40 /* ARROW_DOWN */) return ACTION.DOWN;
        if (keyCode == 10 /* ENTER */) return ACTION.SELECT;

        return ACTION.NONE;
    }

    public Set<ACTION> getActions() {
        return actionSet;
    }

    public AWTTerminalFontConfiguration getFontConfiguration() throws IOException, URISyntaxException, FontFormatException {
        URL resource = getClass().getClassLoader().getResource("fonts/square.ttf");
        File fontFile = new File(resource.toURI());
        Font font =  Font.createFont(Font.TRUETYPE_FONT, fontFile);
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);
        Font newfont = font.deriveFont(Font.PLAIN, 18);

        return AWTTerminalFontConfiguration.newInstance(newfont);
    }

    public Screen createScreen(Terminal terminal) throws IOException {
        final Screen screen;
        screen = new TerminalScreen(terminal);

        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
        return screen;
    }

    public Terminal createTerminal(int width, int height, AWTTerminalFontConfiguration cfg) throws IOException {
        return new DefaultTerminalFactory()
                .setInitialTerminalSize(new TerminalSize(width, height))
                .setTerminalEmulatorFontConfiguration(cfg)
                .setForceAWTOverSwing(true)
                .createTerminal();
    }

    public void drawText(int x, int y, String s, String color) {
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setForegroundColor(TextColor.Factory.fromString(color));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(x, y, s);
    }

    public void drawSurvivor(Position position) {
        drawText(position.x(), position.y(), "S", "#FFD700");
    }

    public void drawMonster(Position position) {
        drawText(position.x(), position.y(), "M", "#FF0000");
    }

    @Override
    public void clear() {
        screen.clear();
    }

    @Override
    public void refresh() throws IOException {
        screen.refresh();
    }

    @Override
    public void close() throws IOException {
        screen.close();
    }
}
