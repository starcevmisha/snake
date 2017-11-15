package SnakeGame.models.tests;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class PointTests {
    @Test
    void Init() {
        Point point = new Point(5, -8);
        assertEquals(point.x, 5);
        assertEquals(point.y, -8);
    }

    @Test
    void Equality() {
        Point first = new Point(1, 2);
        Point second = new Point(1, 2);
        assertEquals(first, second);
        assertFalse(first == second);
        assertTrue(first.equals(second));
    }

    @Test
    void Difference() {
        Point first = new Point(1, 2);
        Point second = new Point(1, 8);
        assertNotEquals(first, second);
        assertFalse(first.equals(second));
    }
}
