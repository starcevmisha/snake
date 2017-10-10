package Snake.gui;

import Snake.Game;

import javax.swing.*;
import java.awt.*;

public class InfoLayout extends JPanel {
    private Game game;
    private static final Font LARGE_FONT = new Font("Tahoma", Font.BOLD, 20);
    private static final Font MEDIUM_FONT = new Font("Tahoma", Font.BOLD, 16);
    private static final Font SMALL_FONT = new Font("Tahoma", Font.BOLD, 12);

    public InfoLayout(Game game) {
        this.game = game;
        setPreferredSize(new Dimension(200, 400));
        setBackground(Color.BLACK);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.GREEN);


        g.setFont(LARGE_FONT);
        g.drawString(
                "Snake Game",
                getWidth() / 2 - g.getFontMetrics().stringWidth("Snake Game") / 2,
                50);

        g.setFont(MEDIUM_FONT);
        g.drawString("Statistics:", 30, 90);
        g.drawString("Controls:", 30, 180);

        g.setFont(SMALL_FONT);

        g.drawString("Total Score: " + game.score, 50, 120);
        g.drawString("Snake length: " + game.snake.getSnakeBody().size(),
                50, 150);

        g.drawString("Up: W / Up ", 50, 210);
        g.drawString("Down: S / Down ", 50, 240);
        g.drawString("Left: A / Left ", 50, 270);
        g.drawString("Right: D / Right ", 50, 300);
        g.drawString("Pause: P", 50, 330);
        g.drawString("Restart Game: Enter", 50, 360);
    }
}