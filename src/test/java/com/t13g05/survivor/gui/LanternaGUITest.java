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
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class LanternaGUITest {
    private Screen screen;
    private LanternaGUI gui;
    private TextGraphics tg;
    private AWTTerminal terminal;

    @BeforeEach
    void setUp() {
        screen = Mockito.mock(Screen.class);
        tg = Mockito.mock(TextGraphics.class);
        terminal = Mockito.mock(AWTTerminal.class);
        Mockito.when(screen.newTextGraphics()).thenReturn(tg);
        gui = new LanternaGUI(screen);
    }

    @Test
    public void fontConfig_test() throws Exception {
        AWTTerminalFontConfiguration fontConfiguration = gui.getFontConfiguration();
        Assertions.assertNotNull(fontConfiguration);
    }

    //@Test
    public void terminal_test() throws Exception {
        AWTTerminalFontConfiguration fontConfig = gui.getFontConfiguration();
        Terminal terminal = gui.createTerminal(40, 20, fontConfig);

        Assertions.assertNotNull(terminal);
    }

    //@Test
    public void screen_test() throws Exception {
        AWTTerminalFontConfiguration fontConfig = gui.getFontConfiguration();
        Terminal terminal = gui.createTerminal(40, 20, fontConfig);
        Screen screen = gui.createScreen(terminal);

        Assertions.assertNotNull(screen);
    }

    //@Test
    public void keyPressed_test() throws Exception {
        AWTTerminalFrame terminalFrame = Mockito.mock(AWTTerminalFrame.class);
        KeyEvent keyEvent = Mockito.mock(KeyEvent.class);
        Mockito.when(keyEvent.getKeyCode()).thenReturn(KeyEvent.VK_LEFT);
        KeyAdapter keyAdapter = (KeyAdapter) terminalFrame.getComponent(0).getKeyListeners()[0];
        keyAdapter.keyPressed(keyEvent);
        Assertions.assertTrue(gui.getActions().contains(GUI.ACTION.LEFT));

        keyAdapter.keyReleased(keyEvent);
        Assertions.assertFalse(gui.getActions().contains(GUI.ACTION.LEFT));
    }


    @Test
    public void draw_test() throws Exception {
        gui.drawText(10,5, "Hello", "#FF0000");
        Mockito.verify(tg).setForegroundColor(TextColor.Factory.fromString("#FF0000"));
        Mockito.verify(tg).enableModifiers(SGR.BOLD);
        Mockito.verify(tg).putString(10, 6, "Hello");
    }

    @Test
    public void close_test() throws Exception {
        gui.close();
        Mockito.verify(screen).close();
    }

    @Test
    public void key_up_test() throws Exception {
        KeyEvent key = Mockito.mock(KeyEvent.class);
        Mockito.when(key.getKeyCode()).thenReturn(KeyEvent.VK_UP);
        GUI.ACTION action = gui.processAction(key);
        Assertions.assertEquals(GUI.ACTION.UP, action);
    }

    @Test
    public void key_down_test() throws Exception {
        KeyEvent key = Mockito.mock(KeyEvent.class);
        Mockito.when(key.getKeyCode()).thenReturn(KeyEvent.VK_DOWN);
        GUI.ACTION action = gui.processAction(key);
        Assertions.assertEquals(GUI.ACTION.DOWN, action);
    }

    @Test
    public void key_left_test() throws Exception {
        KeyEvent key = Mockito.mock(KeyEvent.class);
        Mockito.when(key.getKeyCode()).thenReturn(KeyEvent.VK_LEFT);
        GUI.ACTION action = gui.processAction(key);
        Assertions.assertEquals(GUI.ACTION.LEFT, action);
    }

    @Test
    public void key_right_test() throws Exception {
        KeyEvent key = Mockito.mock(KeyEvent.class);
        Mockito.when(key.getKeyCode()).thenReturn(KeyEvent.VK_RIGHT);
        GUI.ACTION action = gui.processAction(key);
        Assertions.assertEquals(GUI.ACTION.RIGHT, action);
    }

    @Test
    public void key_enter_test() throws Exception {
        KeyEvent key = Mockito.mock(KeyEvent.class);
        Mockito.when(key.getKeyCode()).thenReturn(KeyEvent.VK_ENTER);
        GUI.ACTION action = gui.processAction(key);
        Assertions.assertEquals(GUI.ACTION.SELECT, action);
    }

    @Test
    public void key_esc_test() throws Exception {
        KeyEvent key = Mockito.mock(KeyEvent.class);
        Mockito.when(key.getKeyCode()).thenReturn(KeyEvent.VK_ESCAPE);
        GUI.ACTION action = gui.processAction(key);
        Assertions.assertEquals(GUI.ACTION.QUIT, action);
    }

    @Test
    public void key_notValid_test() throws Exception {
        KeyEvent key = Mockito.mock(KeyEvent.class);
        Mockito.when(key.getKeyCode()).thenReturn(KeyEvent.VK_UNDEFINED);
        GUI.ACTION action = gui.processAction(key);
        Assertions.assertEquals(GUI.ACTION.NONE, action);
    }
}