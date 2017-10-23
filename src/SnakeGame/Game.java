package SnakeGame;

import SnakeGame.models.Food;
import SnakeGame.models.Snake;
import SnakeGame.models.SuperFood;
import SnakeGame.models.Wall;

import java.awt.*;
import java.util.Random;

public class Game {
    public SuperFood superFood;
    public static boolean isGameOver = false;
    public static boolean isPaused = false;
    public int score = 0;
    public Snake snake;
    public Food food;
    private Random random = new Random();
    public Wall wall;
    public Direction direction = Direction.Right;
    public static int Level = 1;

    public Game() {
        snake = new Snake(10, 10, Main.snakeLength);
        food = new Food();
        superFood = new SuperFood();
        wall = new Wall(Level);
    }

    void oneStep() {
        Point head = snake.move(direction);
        Game.isGameOver =
                snake.isLoop() || wall.isIntersectWith(head);

        Point oldPointFood = new Point((int) food.getX(), (int) food.getY());
        if (food.isEaten(head)) {
            score += food.type;
            if (food.type == 4)
                score += 10;
            snake.extend(oldPointFood);
            newFood();
        }
        if (superFood.isEaten(head)) {
            snake.cut();
            score -= 20;
            newSuperFood();
            superFood.isVisible = false;
        }
        if (!superFood.isVisible)
            if (random.nextInt() % superFood.probability == 0)
                superFood.setVisible();
        if (superFood.isVisible)
            superFood.check();
    }

    public void reset() {
        snake = new Snake(10, 10, Main.snakeLength);
        score = 0;
        newFood();
        isGameOver = false;
        isPaused = false;
        direction = Direction.Right;
    }

    private void newFood() {
        while (snake.isIntersectWith(food)
                || wall.isIntersectWith(food))
            food.nextFood();
    }

    private void newSuperFood() {
        while (snake.isIntersectWith(superFood)
                || wall.isIntersectWith(superFood))
            superFood.nextFood();
    }
}
