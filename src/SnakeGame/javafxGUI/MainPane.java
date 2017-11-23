package SnakeGame.javafxGUI;

import SnakeGame.Game;
import SnakeGame.Main;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;

public class MainPane extends Canvas {
    public MainPane(Game game) {
        Button leftButton = new Button("MAINPANE");
        setWidth(Main.WIDTH * Main.CELL_SIZE);
        setHeight(Main.HEIGHT * Main.CELL_SIZE);

        repaint();
    }

    public void repaint() {
        GraphicsContext gc = getGraphicsContext2D();
        for (int x = 0; x < Main.WIDTH; x++) {
            for (int y = 0; y < Main.HEIGHT; y++) {
                gc.setStroke(Color.DARKGRAY);
                gc.strokeRect(x * Main.CELL_SIZE, y * Main.CELL_SIZE,
                        Main.CELL_SIZE, Main.CELL_SIZE);
            }
        }
    }
}
