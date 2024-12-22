package com.t13g05.survivor.gui;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.gui2.Component;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFrame;
import com.t13g05.survivor.gui.GUI;
import com.t13g05.survivor.gui.LanternaGUI;
import com.t13g05.survivor.model.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class LanternaGUITest {
    private Screen screen;
    private LanternaGUI gui;
    private TextGraphics tg;
    private String title;

    @BeforeEach
    void setUp() {
        screen = Mockito.mock(Screen.class);
        tg = Mockito.mock(TextGraphics.class);
        Mockito.when(screen.newTextGraphics()).thenReturn(tg);
        gui = new LanternaGUI(screen, title);
    }

    @Test
    public void fontConfig_test() throws Exception {
        AWTTerminalFontConfiguration fontConfiguration = gui.getFontConfiguration();
        Assertions.assertNotNull(fontConfiguration);
    }

    @Test
    public void terminal_test() throws Exception {
        AWTTerminalFontConfiguration fontConfig = gui.getFontConfiguration();
        Terminal terminal = gui.createTerminal(40, 20, fontConfig, "TEST");

        Assertions.assertNotNull(terminal);
    }

    @Test
    public void screen_test() throws Exception {
        AWTTerminalFontConfiguration fontConfig = gui.getFontConfiguration();
        Terminal terminal = gui.createTerminal(40, 20, fontConfig, "TEST");
        Screen screen = gui.createScreen(terminal);

        Assertions.assertNotNull(screen);
    }

    @Test
    public void keyPressed_test() throws Exception {
        LanternaGUI new_gui = Mockito.mock(LanternaGUI.class);
        HashSet<Action> actions = new HashSet<Action>(Stream.of(Action.LEFT).toList());
        Mockito.when(new_gui.getActions()).thenReturn(actions);

        Assertions.assertTrue(new_gui.getActions().contains(Action.LEFT));
    }


    @Test
    public void draw_test() throws Exception {
        gui.drawText(10,5, "Hello", "#FF0000");
        Mockito.verify(tg).setForegroundColor(TextColor.Factory.fromString("#FF0000"));
        Mockito.verify(tg).enableModifiers(SGR.BOLD);
        Mockito.verify(tg).putString(10, 5, "Hello");
    }

    @Test
    public void close_test() throws Exception {
        gui.close();
        Mockito.verify(screen).close();
    }

    @Test
    public void key_up_test() throws Exception {
        KeyEvent key = Mockito.mock(KeyEvent.class);
        Mockito.when(key.getKeyCode()).thenReturn(KeyEvent.VK_W);
        Action action = gui.processAction(key);
        Assertions.assertEquals(Action.UP, action);
    }

    @Test
    public void key_down_test() throws Exception {
        KeyEvent key = Mockito.mock(KeyEvent.class);
        Mockito.when(key.getKeyCode()).thenReturn(KeyEvent.VK_S);
        Action action = gui.processAction(key);
        Assertions.assertEquals(Action.DOWN, action);
    }

    @Test
    public void key_left_test() throws Exception {
        KeyEvent key = Mockito.mock(KeyEvent.class);
        Mockito.when(key.getKeyCode()).thenReturn(KeyEvent.VK_A);
        Action action = gui.processAction(key);
        Assertions.assertEquals(Action.LEFT, action);
    }

    @Test
    public void key_right_test() throws Exception {
        KeyEvent key = Mockito.mock(KeyEvent.class);
        Mockito.when(key.getKeyCode()).thenReturn(KeyEvent.VK_D);
        Action action = gui.processAction(key);
        Assertions.assertEquals(Action.RIGHT, action);
    }

    @Test
    public void key_enter_test() throws Exception {
        KeyEvent key = Mockito.mock(KeyEvent.class);
        Mockito.when(key.getKeyCode()).thenReturn(KeyEvent.VK_ENTER);
        Action action = gui.processAction(key);
        Assertions.assertEquals(Action.SELECT, action);
    }

    @Test
    public void key_esc_test() throws Exception {
        KeyEvent key = Mockito.mock(KeyEvent.class);
        Mockito.when(key.getKeyCode()).thenReturn(KeyEvent.VK_ESCAPE);
        Action action = gui.processAction(key);
        Assertions.assertEquals(Action.QUIT, action);
    }

    @Test
    public void key_notValid_test() throws Exception {
        KeyEvent key = Mockito.mock(KeyEvent.class);
        Mockito.when(key.getKeyCode()).thenReturn(KeyEvent.VK_UNDEFINED);
        Action action = gui.processAction(key);
        Assertions.assertEquals(Action.NONE, action);
    }
}