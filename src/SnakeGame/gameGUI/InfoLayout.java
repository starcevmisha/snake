package SnakeGame.gameGUI;

import SnakeGame.Game;

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
    public void paint(Graphics canvas) {
        super.paint(canvas);
        canvas.setColor(Color.GREEN);

        canvas.setFont(LARGE_FONT);
        canvas.drawString(
                "The Snake Game",
                getWidth() / 2 - canvas.getFontMetrics().stringWidth("The Snake Game") / 2,
                50);

        canvas.setFont(MEDIUM_FONT);
        canvas.drawString("Statistics:", 30, 90);
        canvas.drawString("Controls:", 30, 180);

        canvas.setFont(SMALL_FONT);

        canvas.drawString("Total Score: " + game.score, 50, 120);
        canvas.drawString("SnakeGame length: " + game.snake.getBody().size(),
                50, 150);


        int deltay = 25;
        int startY = 210 - deltay;
        canvas.drawString("Up: W / Up ", 50, startY += deltay);
        canvas.drawString("Down: S / Down ", 50, startY += deltay);
        canvas.drawString("Left: A / Left ", 50, startY += deltay);
        canvas.drawString("Right: D / Right ", 50, startY += deltay);
        canvas.drawString("Jump: Space", 50, startY += deltay);
        canvas.drawString("Pause: P", 50, startY += deltay);
        canvas.drawString("Restart Game: Enter", 50, startY += deltay);

    }
}