package Snake.gui;

import Snake.Game;
import Snake.Main;

import javax.swing.*;
import java.awt.*;

public class MainLayout extends JPanel {
    private Game game;

    public MainLayout(Game game) {
        this.game = game;
        setPreferredSize(new Dimension(
                Main.WIDTH * Main.CELL_SIZE,
                Main.HEIGHT * Main.CELL_SIZE)
        );
        setBackground(Color.BLACK);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (int x = 0; x < Main.WIDTH; x++) {//Рисуем сетку
            for (int y = 0; y < Main.HEIGHT; y++) {
                g.setColor(Color.DARK_GRAY);
                g.drawRect(x * Main.CELL_SIZE, y * Main.CELL_SIZE,
                        Main.CELL_SIZE, Main.CELL_SIZE);
            }
        }

        for (Point point : game.wall.getWallMap()) {
            paint_point(g, point, Color.DARK_GRAY);
        }

        paint_point(g, game.food, Color.magenta);

        for (Point point : game.snake.getSnakeBody()) {
            paint_point(g, point, Color.GREEN);
        }

        paint_circle(g, game.snake.getSnakeBody().get(0), Color.black);

        if (Game.isGameOver) {
            g.setColor(Color.red);
            g.setFont(new Font("Arial", Font.BOLD, 40));
            FontMetrics fm = g.getFontMetrics();
            g.drawString("GAME OVER", (Main.WIDTH * Main.CELL_SIZE - fm.stringWidth("GAME OVER")) / 2,
                    (Main.HEIGHT * Main.CELL_SIZE) / 2);
        }
    }

    private void paint_point(Graphics g, Point p, Color color) {
        g.setColor(color);
        g.fillRect(p.x * Main.CELL_SIZE, p.y * Main.CELL_SIZE,
                Main.CELL_SIZE, Main.CELL_SIZE);
        g.setColor(Color.GRAY);
        g.drawRect(p.x * Main.CELL_SIZE, p.y * Main.CELL_SIZE,
                Main.CELL_SIZE, Main.CELL_SIZE);
    }

    private void paint_circle(Graphics g, Point p, Color color) {
        g.setColor(color);
        g.fillArc(p.x * Main.CELL_SIZE, p.y * Main.CELL_SIZE,
                Main.CELL_SIZE / 2, Main.CELL_SIZE / 2, 0, 360);

    }
}
