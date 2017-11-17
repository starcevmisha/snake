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

class SerializerTest {
    @Test
    void ExtractLevels_ContainsDefaultMaps_Test() {
        ArrayList<Level> levels = new Serializer().extractLevels();
        String[] names = new String[]{
                "Level1", "Level2", "Level3"};
        for (int number = 0; number < names.length; number++) {
            assertEquals(names[number], levels.get(number).name);
        }
    }

    @Test
    void SerializeToString_And_DeserializeFromString_Test() throws IOException, ClassNotFoundException {
        Serializer serializer = new Serializer();

        ArrayList<Level> levels = new ArrayList<>();
        ArrayList<Pair<Point, Integer>> firstLevel = new ArrayList<>();
        firstLevel.add(new Pair<>(new Point(0, 0), 1));
        firstLevel.add(new Pair<>(new Point(0, 1), 1));
        firstLevel.add(new Pair<>(new Point(1, 1), 1));
        levels.add(new Level("TestLevel", firstLevel));

        String serializeResult = serializer.SerializeToString(levels);

        List<Level> deserializedLevels = serializer.DeserializeFromString(serializeResult);

        assertEquals(levels.get(0).name, deserializedLevels.get(0).name);
        assertTrue(
                levels.get(0).map.containsAll(deserializedLevels.get(0).map)
                        && deserializedLevels.get(0).map.containsAll(levels.get(0).map));

    }
}