package SnakeGame;

import SnakeGame.models.Food;
import SnakeGame.models.Snake;
import SnakeGame.models.Wall;

import java.awt.*;

public class Game {
    public static boolean isGameOver = false;
    public static boolean isPaused = false;
    public int score = 0;
    public Snake snake;
    public Food food;
    public Wall wall;
    public Direction direction = Direction.Right;

    public Game() {
        snake = new Snake(10, 10, Main.snakeLength);
        food = new Food();
        wall = new Wall();
    }

    public void oneStep() {
        Point head = snake.newHeadCoordinates(direction);
        Game.isGameOver =
                snake.isIntersectWith(head) || wall.isIntersectWith(head);
        snake.move(head);

        Point oldPointFood = new Point((int) food.getX(), (int) food.getY());
        if (food.isEaten(head)) {
            score += 1;
            snake.extend(oldPointFood);
            newFood();
        }
    }

    public void reset() {
        snake = new Snake(10, 10, Main.snakeLength);
        score = 0;
        newFood();
        isGameOver = false;
        direction = Direction.Right;
    }

    void newFood() {
        while (snake.isIntersectWith(food)
                || wall.isIntersectWith(food))
            food.nextFood();
    }
}
