package Snake4;

import java.awt.*;

public class Game {
    static boolean isGameOver = false;
    static boolean isPaused = false;
    int score = 0;
    Snake snake;
    Food food;
    Wall wall;
    Direction direction = Direction.Right;

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
