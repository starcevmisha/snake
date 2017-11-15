package SnakeGame.serial.tests;

import SnakeGame.Pair;
import SnakeGame.models.Level;
import SnakeGame.serial.StockLevels;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static SnakeGame.serial.StockLevels.extractLevels;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StockLevelsTest {
    private ArrayList<Level> levels = extractLevels();

    @Test
    void extractLevels_Test() {
        String[] names = new String[]{
                "Level 1", "Level 2", "Level 3"};
        for (int number = 0; number < names.length; number++) {
            assertEquals(names[number], levels.get(number).name);
        }
    }

    @Test
    void addAndRemoveLevel_Test() {
        StockLevels.addLevel("TestLevel", new int[][]{
                new int[]{1, 1},
                new int[]{0, 1}});

        List<Level> levels = StockLevels.extractLevels();
        ArrayList<Pair<Point, Integer>> expectedArray = new ArrayList<>();
        expectedArray.add(new Pair<>(new Point(0, 0), 1));
        expectedArray.add(new Pair<>(new Point(0, 1), 1));
        expectedArray.add(new Pair<>(new Point(1, 1), 1));

        try {
            assertEquals("TestLevel", levels.get(levels.size() - 1).name);
            assertTrue(expectedArray.containsAll
                    (levels.get(levels.size() - 1).map)
                    && levels.get(levels.size() - 1).map.containsAll(
                    expectedArray));
        } finally {
            StockLevels.removeLevel(levels.size() - 1);
        }
    }
}