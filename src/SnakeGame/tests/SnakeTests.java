package SnakeGame.tests;

import SnakeGame.Direction;
import SnakeGame.models.Snake;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertTrue;


class SnakeTests {
    private Snake snake = new Snake(10, 10, 10);

    @Test
    void testSnakeMove() {
        Point head = snake.newHeadCoordinates(Direction.Right);
        snake.move(head);
        assertTrue(snake.isIntersectWith(new Point(11, 10)));
    }
}
