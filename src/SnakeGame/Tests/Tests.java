package SnakeGame.Tests;

import SnakeGame.Direction;
import SnakeGame.models.Snake;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Tests {
    Snake snake = new Snake(10, 10, 10);

    @Test
    public void testSnakeMove() {
        Point head = snake.newHeadCoordinates(Direction.Right);
        snake.move(head);

        assertTrue(snake.isIntersectWith(new Point(11, 10)));
    }
}
