package SnakeGame.gameGUI;

import SnakeGame.Game;
import SnakeGame.Main;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

import static java.lang.Math.abs;

public class MainLayout extends JPanel {
    private Random random = new Random();
    private Game game;
    private Color[] superFoodColor = new Color[]{Color.BLACK, Color.BLUE, Color.WHITE, Color.pink};

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
        drawGrid(g);

        for (Point point : game.wall.getWallMap()) {
            paint_point(g, point, Color.DARK_GRAY);
        }
        if (game.food.type == 1)
            paint_point(g, game.food, Color.magenta);
        else if (game.food.type == 2)
            paint_point(g, game.food, Color.ORANGE);
        else if (game.food.type == 3)
            paint_point(g, game.food, Color.RED);
        else
            paint_point(g, game.food, Color.GREEN);

        for (Point point : game.snake.getBody()) {
            paint_point(g, point, Color.GREEN);
        }
        if (game.superFood.isVisible)
            paint_point(g, game.superFood, superFoodColor[abs(random.nextInt()) % 4]);

        paint_circle(g, game.snake.getBody().get(0), Color.black);

        if (Game.isGameOver) {
            g.setColor(Color.red);
            g.setFont(new Font("Arial", Font.BOLD, 40));
            FontMetrics fm = g.getFontMetrics();
            g.drawString("GAME OVER", (Main.WIDTH * Main.CELL_SIZE - fm.stringWidth("GAME OVER")) / 2,
                    (Main.HEIGHT * Main.CELL_SIZE) / 2);
        }
    }

    private void drawGrid(Graphics g) {
        for (int x = 0; x < Main.WIDTH; x++) {//Рисуем сетку
            for (int y = 0; y < Main.HEIGHT; y++) {
                g.setColor(Color.DARK_GRAY);
                g.drawRect(x * Main.CELL_SIZE, y * Main.CELL_SIZE,
                        Main.CELL_SIZE, Main.CELL_SIZE);
            }
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
