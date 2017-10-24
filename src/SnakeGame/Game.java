package SnakeGame;

import SnakeGame.models.Border;
import SnakeGame.models.Food;
import SnakeGame.models.Snake;
import SnakeGame.models.SuperFood;

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
    public Border border;
    public Direction direction = Direction.Right;
    public static int Level = 1;

    public Game() {
        snake = new Snake(10, 10, Main.snakeLength);
        border = new Border(Level);
        food = new Food(this.border, this.snake);
        superFood = new SuperFood(this.border, this.snake);
    }

    void oneStep() {
        Point head = snake.move(direction);
        Game.isGameOver =
                snake.isLoop() || border.isIntersectWith(head);

        Point oldPointFood = new Point((int) food.getX(), (int) food.getY());
        if (food.isEaten(head)) {
            score += food.type;
            if (food.type == 4)
                score += 10;
            snake.extend(oldPointFood);
            food.move();
        }
        if (superFood.isEaten(head)) {
            snake.cut();
            score -= 20;
            superFood.move();
            superFood.visible = false;
        }
        if (!superFood.visible)
            if (random.nextInt() % superFood.probability == 0)
                superFood.setVisible();
        if (superFood.visible)
            superFood.check();
    }

    public void reset() {
        snake = new Snake(10, 10, Main.snakeLength);
        food = new Food(border, snake);
        score = 0;
        food.move();
        isGameOver = false;
        isPaused = false;
        direction = Direction.Right;
    }
}
