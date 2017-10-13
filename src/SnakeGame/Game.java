package SnakeGame;

import SnakeGame.models.Food;
import SnakeGame.models.Snake;
import SnakeGame.models.Wall;

import java.awt.*;

public class Game {
    public static boolean isGameOver = false;
    public static boolean isPaused = true;
    public int score = 0;
    public Snake snake;
    public Food food;
    public Wall wall;
    public Direction direction = Direction.Right;
    public static int Level = 1;

    public Game() {
        snake = new Snake(10, 10, Main.snakeLength);
        food = new Food();
        wall = new Wall(Level);
    }

    public void oneStep() {
        Point head = snake.move(direction);
        Game.isGameOver =
                snake.isLoop() || wall.isIntersectWith(head);

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
        isPaused = false;
        direction = Direction.Right;
    }

    void newFood() {
        while (snake.isIntersectWith(food)
                || wall.isIntersectWith(food))
            food.nextFood();
    }
}
