package SnakeGame.javafxGUI;

import SnakeGame.Game;
import SnakeGame.Main;
import SnakeGame.Pair;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.awt.*;
import java.util.Random;

import static java.lang.Math.abs;

public class MainPane extends Canvas {
    private Game game;
    private Random random = new Random();
    private Color[] superFoodColor = new Color[]
            {Color.BLACK, Color.BLUE, Color.WHITE, Color.PINK};

    public MainPane(Game game) {
        this.game = game;

        setWidth(Main.WIDTH * Main.CELL_SIZE);
        setHeight(Main.HEIGHT * Main.CELL_SIZE);

    }

    public void repaint() {
        GraphicsContext gc = getGraphicsContext2D();

        Color myGray = new Color(0.2, 0.2, 0.2, 1);

        for (int x = 0; x < Main.WIDTH; x++) {
            for (int y = 0; y < Main.HEIGHT; y++) {
                gc.setStroke(Color.DARKGRAY);
                gc.strokeRect(x * Main.CELL_SIZE, y * Main.CELL_SIZE,
                        Main.CELL_SIZE, Main.CELL_SIZE);
                gc.setFill(Color.BLACK);
                gc.fillRect(x * Main.CELL_SIZE, y * Main.CELL_SIZE,
                        Main.CELL_SIZE, Main.CELL_SIZE);
            }
        }
        for (Pair<Point, Integer> pair : game.wall.getWallMap()) {
            paintPoint(gc, pair.getLeft(), new Color(0.2, 0.2, 0.2, 1));
        }
        if (game.food.type == 1)
            paintPoint(gc, game.food, Color.MAGENTA);
        else if (game.food.type == 2)
            paintPoint(gc, game.food, Color.ORANGE);
        else if (game.food.type == 3)
            paintPoint(gc, game.food, Color.RED);
        else
            paintPoint(gc, game.food, Color.YELLOW);

        for (Point point : game.snake.getBody()) {
            paintPoint(gc, point, Color.GREEN);
        }
        if (game.superFood.isVisible)
            paintPoint(gc, game.superFood,
                    superFoodColor[abs(random.nextInt()) % 4]);

        if (Game.isGameOver) {
            gc.setFill(Color.RED);
            gc.setFont(new Font("TAHOMA", 72));
            gc.fillText("GAME OVER",
                    (Main.WIDTH * Main.CELL_SIZE - 400) / 2,
                    (Main.HEIGHT * Main.CELL_SIZE) / 2);
        }

    }

    private void paintPoint(GraphicsContext canvas, Point point, Color color) {
        canvas.setStroke(Color.DARKGRAY);
        canvas.strokeRect(point.x * Main.CELL_SIZE,
                point.y * Main.CELL_SIZE, Main.CELL_SIZE, Main.CELL_SIZE);
        canvas.setFill(color);
        canvas.fillRect(point.x * Main.CELL_SIZE,
                point.y * Main.CELL_SIZE, Main.CELL_SIZE, Main.CELL_SIZE);

    }
}
