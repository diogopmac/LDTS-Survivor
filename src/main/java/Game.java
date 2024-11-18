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

//NÃO COLOCAR DEPOIS
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
//NÃO COLOCAR DEPOIS

public class Game {
    private Screen screen;
    public Game() {
        try {
            URL resource = getClass().getClassLoader().getResource("square.ttf");
            assert resource != null;
            File fontFile = new File(resource.toURI());
            Font font =  Font.createFont(Font.TRUETYPE_FONT, fontFile);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(font);
            Font newfont = font.deriveFont(Font.PLAIN, 4);

            AWTTerminalFontConfiguration cfg = AWTTerminalFontConfiguration.newInstance(newfont);

            int width = 800, height = 220;
            Terminal terminal = new DefaultTerminalFactory()
                    .setInitialTerminalSize(new TerminalSize(width, height))
                    .setTerminalEmulatorFontConfiguration(cfg)
                    .setForceAWTOverSwing(true)
                    .createTerminal();
            screen = new TerminalScreen(terminal);
            TextGraphics graphics = screen.newTextGraphics();

            graphics.setBackgroundColor(TextColor.Factory.fromString("#000000"));
            graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');

            screen.setCursorPosition(null);
            screen.startScreen();
            screen.doResizeIfNecessary();

            screen.startScreen();

            //Só para testar
            boolean running = true;

            while (running) {
                KeyStroke keyStroke = screen.readInput();
                if (keyStroke != null) {
                    if (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == 'q') {
                        running = false;
                    }
                }
            }
            screen.stopScreen();
            //Só para testar

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (FontFormatException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

    }
}
