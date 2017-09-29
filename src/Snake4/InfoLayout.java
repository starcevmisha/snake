package Snake4;

import javax.swing.*;
import java.awt.*;

public class InfoLayout extends JPanel {
    SnakeGame game;
    private static final Font LARGE_FONT = new Font("Tahoma", Font.BOLD, 20);
    private static final Font MEDIUM_FONT = new Font("Tahoma", Font.BOLD, 16);
    private static final Font SMALL_FONT = new Font("Tahoma", Font.BOLD, 12);

    public InfoLayout(SnakeGame game) {
        this.game = game;
        setPreferredSize(new Dimension(200, 400));
        setBackground(Color.BLACK);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.GREEN);


        g.setFont(LARGE_FONT);
        g.drawString("Snake Game", getWidth() / 2 - g.getFontMetrics().stringWidth("Snake Game") / 2, 50);

        g.setFont(MEDIUM_FONT);
        g.drawString("Statistics:", 30, 90);
        g.drawString("Controls:", 30, 180);

        g.setFont(SMALL_FONT);
        int drawy = 90;
        g.drawString("Total Score: " + game.score, 50, drawy += 30);
        g.drawString("Snake length: " + game.snake.getSnakeBody().size(), 50, drawy += 30);

        int drawY = 180;
        g.drawString("Up: W / Up ", 50, drawY += 30);
        g.drawString("Down: S / Down ", 50, drawY += 30);
        g.drawString("Left: A / Left ", 50, drawY += 30);
        g.drawString("MRight: D / Right ", 50, drawY += 30);
        g.drawString("Pause: P", 50, drawY += 30);
    }
}