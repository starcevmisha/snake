package SnakeGame.tests;

import SnakeGame.models.Food;
import org.junit.jupiter.api.Test;

import static java.lang.Math.pow;
import static org.junit.jupiter.api.Assertions.assertEquals;


class FoodTests {
    @Test
    void testInit() {
        new Food();
    }

    @Test
    void testSet() {
        Food food = new Food();
        food.setXY((int) pow(10, 100),
                -(int) pow(10, 100));
        assertEquals((int) pow(10, 100), food.x);
        assertEquals((int) pow(10, 100) * -1, food.y);
    }
}
