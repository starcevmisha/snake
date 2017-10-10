package SnakeGame.models;

import SnakeGame.Main;

import java.awt.*;
import java.util.Random;

public class Food extends Point {
    private Random random = new Random(34567542);

    public Food() {
        super(18, 10);
    }

    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void nextFood() {
        x = random.nextInt(Main.WIDTH);
        y = random.nextInt(Main.HEIGHT);
    }

    public boolean isEaten(Point snakeHead) {
        return (snakeHead.getX() == this.getX())
                && (snakeHead.getY() == this.getY());
    }
}
