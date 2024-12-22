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
import java.util.LinkedHashSet;
import java.util.Set;

public class LanternaGUI implements GUI{
    private final Screen screen;
    private Set<Action> actionSet = new LinkedHashSet<Action>();
    private String title;
    public LanternaGUI(Screen screen, String title) {
        this.screen = screen;
        this.title = title;
    }

    public LanternaGUI(int width, int height, String title) throws IOException, FontFormatException, URISyntaxException {
        AWTTerminalFontConfiguration fontConfig = getFontConfiguration();
        Terminal terminal = createTerminal(width, height, fontConfig, title);
        this.screen = createScreen(terminal);
        this.title = title;

        ((AWTTerminalFrame)terminal).getComponent(0).addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                Action action = processAction(e);
                if (action != Action.NONE) actionSet.add(action);
            }
            @Override
            public void keyReleased(KeyEvent e) {
                Action action = processAction(e);
                if (action != Action.NONE) actionSet.remove(action);
            }
        });
    }


    public Action processAction(KeyEvent e) {
        int keyCode = e.getKeyCode();

        if (keyCode == 27 /* ESCAPE */) return Action.QUIT;

        if (keyCode == 65 /* A */) return Action.LEFT;
        if (keyCode == 87 /* W */) return Action.UP;
        if (keyCode == 68 /* D */) return Action.RIGHT;
        if (keyCode == 83 /* S */) return Action.DOWN;
        if (keyCode == 10 /* ENTER */) return Action.SELECT;

        if (keyCode == 80 /* P */) return Action.SHOOT;
        if (keyCode == 79 /* O */) return Action.USE;

        return Action.NONE;
    }

    public Set<Action> getActions() {
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

    public Terminal createTerminal(int width, int height, AWTTerminalFontConfiguration cfg, String title) throws IOException {
        return new DefaultTerminalFactory()
                .setInitialTerminalSize(new TerminalSize(width, height))
                .setTerminalEmulatorFontConfiguration(cfg)
                .setForceAWTOverSwing(true).setTerminalEmulatorTitle(title)
                .createTerminal();
    }

    public void drawText(int x, int y, String s, String color) {
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setForegroundColor(TextColor.Factory.fromString(color));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(x, y, s);
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
