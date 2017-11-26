package SnakeGame.javafxGUI;

import SnakeGame.Game;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class InfoPane extends Canvas {
    private static final Font LARGE_FONT = Font.font("Tahoma", FontWeight.BOLD, 40);
    private static final Font MEDIUM_FONT = Font.font("Tahoma", FontWeight.EXTRA_LIGHT, 16);
    private static final Font SMALL_FONT = Font.font("Tahoma", FontWeight.EXTRA_LIGHT, 12);
    private Game game;

    public InfoPane(Game game) {
        this.game = game;
        setWidth(200);
        setHeight(400);
    }

    public void repaint() {

        GraphicsContext gc = getGraphicsContext2D();
        gc.clearRect(0, 0, 200, 400);
        gc.setFill(Color.GREEN);
        gc.setFont(LARGE_FONT);
        gc.fillText("SNAKE", 20, 50);


        gc.setFont(MEDIUM_FONT);
        gc.fillText("Statistics:", 30, 90);
        gc.fillText("Controls:", 30, 180);

        gc.setFont(SMALL_FONT);

        gc.fillText("Total Score: " + game.score, 50, 120);
        gc.fillText("SnakeGame length: " + game.snake.getBody().size(),
                50, 150);


        int deltay = 25;
        int startY = 210 - deltay;
        gc.fillText("Up: W / Up ", 50, startY += deltay);
        gc.fillText("Down: S / Down ", 50, startY += deltay);
        gc.fillText("Left: A / Left ", 50, startY += deltay);
        gc.fillText("Right: D / Right ", 50, startY += deltay);
        gc.fillText("Jump: Space", 50, startY += deltay);
        gc.fillText("Pause: P", 50, startY += deltay);
        gc.fillText("Restart Game: Enter", 50, startY += deltay);


    }
}
