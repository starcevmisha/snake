package SnakeGame.serial;

import SnakeGame.Pair;
import SnakeGame.models.Level;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;


public class StockLevels {


    private static String filename = "src\\SnakeGame\\serial\\levels.json";

    public static void main(String[] args) {
//        deleteLevel(3);
    }

    public static ArrayList<Level> extractLevels() {
        return Deserialize();
    }

    private static void addLevelToFile(String name, ArrayList<Pair<Point, Integer>> map) {
        ArrayList<Level> levels = Deserialize();
        if (levels == null)
            levels = new ArrayList<Level>();
        levels.add(new Level(name, map));
        Serialize(levels);
    }

    public static void addLevel(String name, int[][] map) {
        ArrayList<Pair<Point, Integer>> level = new ArrayList<>();
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[j][i] > 0)
                    level.add(new Pair(new Point(j, i), map[j][i]));
            }
        }
        addLevelToFile(name, level);
    }

    public static void deleteLevel(int index) {
        ArrayList<Level> levels = Deserialize();
        levels.remove(index);
        Serialize(levels);
    }

    public static void Serialize(ArrayList<Level> levels) {

        try {
            FileOutputStream fos = new FileOutputStream("src\\SnakeGame\\serial\\levels");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(levels);
            oos.close();
            fos.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static ArrayList<Level> Deserialize() {
        try {
            FileInputStream fis = new FileInputStream("src\\SnakeGame\\serial\\levels");
            ObjectInputStream ois = new ObjectInputStream(fis);
            ArrayList<Level> levels = (ArrayList<Level>) ois.readObject();
            ois.close();
            fis.close();
            return levels;
        } catch (IOException ioe) {
            ioe.printStackTrace();
            return null;
        } catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();
            return null;
        }
    }

}
