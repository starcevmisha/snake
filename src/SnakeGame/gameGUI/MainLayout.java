package SnakeGame.gameGUI;

import SnakeGame.Game;
import SnakeGame.Main;
import SnakeGame.Pair;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

import static java.lang.Math.abs;

public class MainLayout extends JPanel {
    private Random random = new Random();
    private Game game;
    private Color[] superFoodColor = new Color[]
            {Color.BLACK, Color.BLUE, Color.WHITE, Color.pink};

    public MainLayout(Game game) {
        this.game = game;
        setPreferredSize(new Dimension(
                Main.WIDTH * Main.CELL_SIZE,
                Main.HEIGHT * Main.CELL_SIZE)
        );
        setBackground(Color.BLACK);
    }

    @Override
    public void paint(Graphics canvas) {
        super.paint(canvas);
        drawGrid(canvas);

        for (Pair<Point, Integer> pair : Game.wall.getWallMap()) {
            paintPoint(canvas, pair.getLeft(), Color.DARK_GRAY);
        }
        if (game.food.type == 1)
            paintPoint(canvas, game.food, Color.magenta);
        else if (game.food.type == 2)
            paintPoint(canvas, game.food, Color.ORANGE);
        else if (game.food.type == 3)
            paintPoint(canvas, game.food, Color.RED);
        else
            paintPoint(canvas, game.food, Color.GREEN);

        for (Point point : game.snake.getBody()) {
            paintPoint(canvas, point, Color.GREEN);
        }
        if (game.superFood.isVisible)
            paintPoint(canvas, game.superFood,
                    superFoodColor[abs(random.nextInt()) % 4]);

        paintCircle(canvas, game.snake.getBody().get(0), Color.black);

        if (Game.isGameOver) {
            canvas.setColor(Color.red);
            canvas.setFont(new Font("Arial", Font.BOLD, 40));
            FontMetrics fm = canvas.getFontMetrics();
            canvas.drawString("GAME OVER",
                    (Main.WIDTH * Main.CELL_SIZE -
                            fm.stringWidth("GAME OVER")) / 2,
                    (Main.HEIGHT * Main.CELL_SIZE) / 2);
        }
    }

    private void drawGrid(Graphics canvas) {
        for (int x = 0; x < Main.WIDTH; x++) {//Рисуем сетку
            for (int y = 0; y < Main.HEIGHT; y++) {
                canvas.setColor(Color.DARK_GRAY);
                canvas.drawRect(x * Main.CELL_SIZE, y * Main.CELL_SIZE,
                        Main.CELL_SIZE, Main.CELL_SIZE);
            }
        }
    }

    private void paintPoint(Graphics canvas, Point point, Color color) {
        canvas.setColor(color);
        canvas.fillRect(point.x * Main.CELL_SIZE,
                point.y * Main.CELL_SIZE, Main.CELL_SIZE, Main.CELL_SIZE);
        canvas.setColor(Color.GRAY);
        canvas.drawRect(point.x * Main.CELL_SIZE,
                point.y * Main.CELL_SIZE, Main.CELL_SIZE, Main.CELL_SIZE);
    }

    private void paintCircle(Graphics canvas, Point point, Color color) {
        canvas.setColor(color);
        canvas.fillArc(point.x * Main.CELL_SIZE,
                point.y * Main.CELL_SIZE,
                Main.CELL_SIZE / 2,
                Main.CELL_SIZE / 2,
                0, 360);

    }
}
