package SnakeGame.serial;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


public class JsonLevels {
    private static File file = new File("src\\SnakeGame\\" +
            "serial\\levels.json");

    public static void main(String[] args) throws IOException {
        List<Level> levels = extractLevels();
        addLevel("23", new String[]{"12", "345"});

    }

    public static List<Level> extractLevels() {

        JsonReader reader = null;
        try {
            reader = new JsonReader(new FileReader(file));
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<Level>>() {
        }.getType();

        assert reader != null;
        return gson.fromJson(reader, type);
    }

    private static void addLevel(String name, String[] map) {
        List<Level> levels = extractLevels();
        levels.add(new Level(name, map));
        Gson gson = new Gson();
        gson.toJson(levels);
        try {
            Files.write(
                    Paths.get("src\\SnakeGame\\serial\\levels.json"),
                    gson.toJson(levels).getBytes());
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public static void addLevel(String name, boolean[][] map) {
        String[] res = new String[map.length];
        for (int i = 0; i < map.length; i++) {
            StringBuilder temp = new StringBuilder();
            for (int j = 0; j < map[0].length; j++) {
                if (map[j][i])
                    temp.append("1");
                else
                    temp.append("0");
            }
            res[i] = temp.toString();
        }
        addLevel(name, res);
    }

    public static class Level {
        public String name;
        public String[] map;

        Level(String name, String[] map) {
            this.name = name;
            this.map = map;
        }
    }
}
