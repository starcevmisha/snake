package SnakeGame.serial.tests;

import SnakeGame.Pair;
import SnakeGame.models.Level;
import SnakeGame.serial.Serializer;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SerializerTests {
    private ArrayList<Pair<Point, Integer>> getMap() {
        ArrayList<Pair<Point, Integer>> map = new ArrayList<>();
        map.add(new Pair<>(new Point(1, 2), 0));
        map.add(new Pair<>(new Point(3, 4), 1));
        return map;
    }

    private ArrayList<Level> getLevels() {
        ArrayList<Level> levels = new ArrayList<>();
        ArrayList<Pair<Point, Integer>> map = getMap();
        levels.add(new Level("Test", map));
        return levels;
    }

    private boolean compareArrayLists(ArrayList<Level> first,
                                      ArrayList<Level> second) {
        return first.containsAll(second) && second.containsAll(first);
    }

    @Test
    void SerializeEquality() {
        Serializer serializer = new Serializer();
        ArrayList<Level> levels = getLevels();
        ArrayList<Level> copy = getLevels();
        assertEquals(serializer.SerializeToString(levels),
                serializer.SerializeToString(levels));
        assertEquals(serializer.SerializeToString(levels),
                serializer.SerializeToString(copy));

    }

    @Test
    void DeserializeEquality() {
        Serializer serializer = new Serializer();
        ArrayList<Level> levels = getLevels();
        ArrayList<Level> copy = getLevels();
        String serializedLevels = serializer.SerializeToString(levels);
        String serializedCopy = serializer.SerializeToString(copy);
        try {
            assertTrue(
                    compareArrayLists(serializer.DeserializeFromString(
                            serializedLevels),
                            serializer.DeserializeFromString(
                                    serializedLevels)));
            assertTrue(
                    compareArrayLists(serializer.DeserializeFromString(
                            serializedLevels),
                            serializer.DeserializeFromString(
                                    serializedCopy)));
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Test
    void AddAndRemoveLevels() throws IOException,
            ClassNotFoundException {
        Serializer serializer = new Serializer();

        ArrayList<Level> levels = new ArrayList<>();
        ArrayList<Pair<Point, Integer>> firstLevel = new ArrayList<>();
        firstLevel.add(new Pair<>(new Point(0, 0), 1));
        firstLevel.add(new Pair<>(new Point(0, 1), 1));
        firstLevel.add(new Pair<>(new Point(1, 1), 1));
        levels.add(new Level("TestLevel", firstLevel));

        String serializeResult = serializer.SerializeToString(levels);

        List<Level> deserializedLevels = serializer.DeserializeFromString(
                serializeResult);

        assertEquals(levels.get(0).name, deserializedLevels.get(0).name);
        assertTrue(
                levels.get(0).map.containsAll(
                        deserializedLevels.get(0).map)
                        && deserializedLevels.get(0).map.containsAll(
                        levels.get(0).map));
    }
}