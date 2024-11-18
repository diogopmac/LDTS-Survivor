import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class Game {
    private Screen screen;
    private Arena arena;
    public Game() {
        try {
            URL resource = getClass().getClassLoader().getResource("square.ttf");
            File fontFile = new File(resource.toURI());
            Font font =  Font.createFont(Font.TRUETYPE_FONT, fontFile);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(font);
            Font newfont = font.deriveFont(Font.PLAIN, 18);

            AWTTerminalFontConfiguration cfg = AWTTerminalFontConfiguration.newInstance(newfont);

            int width = 70, height = 45;
            Terminal terminal = new DefaultTerminalFactory()
                    .setInitialTerminalSize(new TerminalSize(width, height))
                    .setTerminalEmulatorFontConfiguration(cfg)
                    .setForceAWTOverSwing(true)
                    .createTerminal();
            screen = new TerminalScreen(terminal);
          
            arena = new Arena(width, height);

            TextGraphics graphics = screen.newTextGraphics();
            graphics.setBackgroundColor(TextColor.Factory.fromString("#000000"));
            graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');

            screen.setCursorPosition(null);
            screen.startScreen();
            screen.doResizeIfNecessary();

        } catch (IOException | FontFormatException | URISyntaxException e) {
            throw new RuntimeException(e);
        }

    }

    public void draw() throws IOException {
        screen.clear();
        arena.draw(screen.newTextGraphics());
        screen.refresh();
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
}
