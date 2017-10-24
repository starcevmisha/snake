package SnakeGame.models;

import SnakeGame.Main;

import java.awt.*;
import java.util.Random;

import static java.lang.Math.abs;

public class Food extends Point {
    private Random random = new Random();
    private Border border;
    private Snake snake;
    public int type = 1;

    public Food(Border border, Snake snake) {
        super(0, 0);
        this.border = border;
        this.snake = snake;
        this.move();
    }

    public Food() {
        super(0, 0);
    }

    public void setCoordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    private void nextFood() {
        this.setCoordinates(random.nextInt(Main.WIDTH), random.nextInt(Main.WIDTH));
        type = abs(random.nextInt()) % 3 + 1;
        if (abs(random.nextInt()) % 51 == 0)
            type = 4;
    }

    public boolean isEaten(Point snakeHead) {
        return (snakeHead.getX() == this.getX())
                && (snakeHead.getY() == this.getY());
    }

    public void move() {
        random = new Random();
        while (snake.isIntersectWith(this)
                || border.isIntersectWith(this))
            this.nextFood();
    }
}
