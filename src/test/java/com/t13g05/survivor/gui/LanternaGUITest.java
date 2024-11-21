package com.t13g05.survivor.gui;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import com.t13g05.survivor.gui.GUI;
import com.t13g05.survivor.gui.LanternaGUI;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.awt.event.KeyEvent;

public class LanternaGUITest {
    private Screen screen;
    private LanternaGUI gui;
    private TextGraphics tg;

    @BeforeEach
    void setUp() {
        screen = Mockito.mock(Screen.class);
        tg = Mockito.mock(TextGraphics.class);
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
    public void key_notValid_test() throws Exception {
        KeyEvent key = Mockito.mock(KeyEvent.class);
        Mockito.when(key.getKeyCode()).thenReturn(KeyEvent.VK_UNDEFINED);
        GUI.ACTION action = gui.processAction(key);
        Assertions.assertEquals(GUI.ACTION.NONE, action);
    }
}