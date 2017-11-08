package SnakeGame.serial;

import SnakeGame.models.Level;
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


public class StockLevels {
    private static File file = new File("src\\SnakeGame\\" +
            "serial\\levels.json");

    @Deprecated
    public static void main(String[] args) throws IOException {
        //List<Level> levels = extractLevels();
        //addLevel("23", new String[]{"12", "345"});
    }

    public static List<Level> extractLevels() {
        JsonReader reader = null;
        try {
            reader = new JsonReader(new FileReader(file));
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        }
        assert reader != null;
        Gson gson = new Gson();
        Type type = new TypeToken<List<Level>>() {
        }.getType();
        return gson.fromJson(reader, type);
    }

    private static void addLevelToFile(String name, String[] map) {
        List<Level> levels = extractLevels();
        if (levels != null)
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
        addLevelToFile(name, res);
    }

    private static int findLevel(String name, List<Level> levels) {
        int answer = -1;
        for (int index = 0; index < levels.size(); index++) {
            Level level = levels.get(index);
            if (level.name.equals(name))
                return index;
        }
        return answer;
    }

    public static void removeLevel(String name) {
        List<Level> levels = extractLevels();
        int index = findLevel(name, levels);
        if (index >= 0)
            removeLevel(index);
    }

    private static void removeLevel(int id) {
        List<Level> levels = extractLevels();
        if (id < levels.size())
            levels.remove(id);
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
}
