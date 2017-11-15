package SnakeGame.models.tests;

import SnakeGame.Pair;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PairTests {
    @Test
    void Init() {
        Pair<Integer, String> subject = new Pair<>(12, "123");
        assertEquals(subject.getLeft(), (Integer) 12);
        assertEquals(subject.getRight(), "123");
    }

    @Test
    void Equality() {
        Pair<Pair<Integer, Double>, Boolean> first =
                new Pair<>(new Pair<>(2, 0.8), false);
        Pair<Pair<Integer, Double>, Boolean> second =
                new Pair<>(new Pair<>(4 - 2, 4.0 / 5), false);
        assertEquals(first, second);
        assertTrue(second.equals(first));
    }
}
