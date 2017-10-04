package Snake4;

import javax.swing.*;
import java.awt.*;

public class MainLayout extends JPanel {
    private SnakeGame game;

    MainLayout(SnakeGame game) {
        this.game = game;
        setPreferredSize(new Dimension(
                SnakeGame.WIDTH * SnakeGame.CELL_SIZE,
                SnakeGame.HEIGHT * SnakeGame.CELL_SIZE)
        );
        setBackground(Color.BLACK);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (int x = 0; x < SnakeGame.WIDTH; x++) {
            for (int y = 0; y < SnakeGame.HEIGHT; y++) {
                g.setColor(Color.DARK_GRAY);
                g.drawRect(x * SnakeGame.CELL_SIZE, y * SnakeGame.CELL_SIZE,
                        SnakeGame.CELL_SIZE, SnakeGame.CELL_SIZE);
            }
        }
        for (Point point : game.snake.getSnakeBody()) {
            paint_point(g, point, Color.GREEN);
        }
        paint_circle(g, game.snake.getSnakeBody().get(0), Color.black);


        paint_point(g, game.food, Color.magenta);

        if (SnakeGame.isGameOver) {
            g.setColor(Color.red);
            g.setFont(new Font("Arial", Font.BOLD, 40));
            FontMetrics fm = g.getFontMetrics();
            g.drawString("GAME OVER", (SnakeGame.WIDTH * SnakeGame.CELL_SIZE - fm.stringWidth("GAME OVER")) / 2,
                    (SnakeGame.HEIGHT * SnakeGame.CELL_SIZE) / 2);
        }
    }

    private void paint_point(Graphics g, Point p, Color color) {
        g.setColor(color);
        g.fillRect(p.x * SnakeGame.CELL_SIZE, p.y * SnakeGame.CELL_SIZE,
                SnakeGame.CELL_SIZE, SnakeGame.CELL_SIZE);
        g.setColor(Color.GRAY);
        g.drawRect(p.x * SnakeGame.CELL_SIZE, p.y * SnakeGame.CELL_SIZE,
                SnakeGame.CELL_SIZE, SnakeGame.CELL_SIZE);
    }

    private void paint_circle(Graphics g, Point p, Color color) {
        g.setColor(color);
        g.fillArc(p.x * SnakeGame.CELL_SIZE, p.y * SnakeGame.CELL_SIZE,
                SnakeGame.CELL_SIZE / 2, SnakeGame.CELL_SIZE / 2, 0, 360);

    }
}
