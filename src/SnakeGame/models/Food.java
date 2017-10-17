package SnakeGame.models;

import SnakeGame.Main;

import java.awt.*;
import java.util.Random;

import static java.lang.Math.abs;

public class Food extends Point {
    private Random random = new Random();
    public int type = 1;

    public Food() {
        super(18, 10);
    }

    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void nextFood() {
        this.x = random.nextInt(Main.WIDTH);
        this.y = random.nextInt(Main.HEIGHT);
        type = abs(random.nextInt()) % 3 + 1;
        if (abs(random.nextInt()) % 51 == 0)
            type = 4;
    }

    public boolean isEaten(Point snakeHead) {
        return (snakeHead.getX() == this.getX())
                && (snakeHead.getY() == this.getY());
    }
}
