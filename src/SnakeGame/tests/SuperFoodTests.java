package SnakeGame.tests;

import SnakeGame.models.SuperFood;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SuperFoodTests {
    @Test
    void testInit() {
        SuperFood superFood = new SuperFood();
        assertTrue(superFood.x >= 0);
        assertTrue(superFood.y >= 0);
    }

    @Test
    void testSetVisible() {
        SuperFood superFood = new SuperFood();
        assertFalse(superFood.visible);
        superFood.setVisible();
        assertTrue(superFood.visible);
    }
}
