package SnakeGame.tests;

import SnakeGame.Direction;
import SnakeGame.models.Food;
import SnakeGame.models.Snake;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertTrue;


class SnakeTests {

    @Test
    void testMove() {
        Snake snake = new Snake(10, 10, 10);
        snake.move(Direction.Right);
        assertTrue(snake.isIntersectWith(new Point(11, 10)));
    }

    @Test
    void testLoop() {
        Snake snake = new Snake(10, 10, 10);
        snake.move(Direction.Down);
        snake.move(Direction.Left);
        snake.move(Direction.Up);
        assertTrue(snake.isLoop());
    }

    @Test
    void testFoodEaten() {
        Snake snake = new Snake(10, 10, 10);
        Food food = new Food();
        food.setXY(11, 10);
        Point head = snake.move(Direction.Right);
        assertTrue(food.isEaten(head));
    }

}
