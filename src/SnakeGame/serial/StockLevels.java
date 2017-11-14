package SnakeGame.serial;

import SnakeGame.Pair;
import SnakeGame.models.Level;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;


public class StockLevels {
    private static String filename = "src\\SnakeGame\\serial\\levels.json";

    public static void main(String[] args) {
        System.out.println(extractLevels().size());
//        removeLevel(extractLevels().size()-1);
    }

    public static ArrayList<Level> extractLevels() {
        return deserialize();
    }

    private static void addLevelToFile(String name, ArrayList<Pair<Point, Integer>> map) {
        ArrayList<Level> levels = deserialize();
        if (levels == null)
            levels = new ArrayList<>();
        levels.add(new Level(name, map));
        serialize(levels);
    }

    public static void addLevel(String name, int[][] map) {
        ArrayList<Pair<Point, Integer>> level = new ArrayList<>();
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[j][i] > 0)
                    level.add(new Pair<>(new Point(j, i), map[j][i]));
            }
        }
        addLevelToFile(name, level);
    }

    public static void removeLevel(int index) {
        ArrayList<Level> levels = deserialize();
        if (levels != null)
            levels.remove(index);
        serialize(levels);
    }

    private static void serialize(ArrayList<Level> levels) {
        try {
            FileOutputStream fos = new FileOutputStream(
                    "src\\SnakeGame\\serial\\levels");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(levels);
            oos.close();
            fos.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    private static ArrayList<Level> deserialize() {
        try {
            FileInputStream fis = new FileInputStream(
                    "src\\SnakeGame\\serial\\levels");
            ObjectInputStream ois = new ObjectInputStream(fis);
            ArrayList<Level> levels = (ArrayList<Level>) ois.readObject();
            ois.close();
            fis.close();
            return levels;
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();
        }
        return null;
    }
}
