package SnakeGame.models.tests;

import SnakeGame.models.Level;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LevelTest {
    @Test
    void Init() {
        Level subject = new Level("Subject",
                new String[]{"123", "0123"});
        assertEquals("Subject", subject.name);
        assertTrue(Arrays.equals(new String[]{"123", "0123"}, subject.map));
    }
}