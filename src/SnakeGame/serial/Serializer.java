package SnakeGame.serial;

import SnakeGame.Pair;
import SnakeGame.models.Level;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Base64;


public class Serializer {
    private static String filename = "src\\SnakeGame\\serial\\levels.base64";

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ArrayList<Level> levels = new ArrayList<>();

        ArrayList<Pair<Point, Integer>> expectedArray = new ArrayList<>();
        expectedArray.add(new Pair<>(new Point(0, 0), 1));
        expectedArray.add(new Pair<>(new Point(0, 1), 1));
        expectedArray.add(new Pair<>(new Point(1, 1), 1));

        levels.add(new Level("hello", expectedArray));

        new Serializer().Serialize(levels);
        ArrayList<Level> newLevels = new Serializer().Deserialize();
    }

    public ArrayList<Level> extractLevels() {
        return Deserialize();
    }

    private void addLevelToFile(String name, ArrayList<Pair<Point, Integer>> map) {
        ArrayList<Level> levels = Deserialize();
        if (levels == null)
            levels = new ArrayList<>();
        levels.add(new Level(name, map));
        Serialize(levels);
    }

    public void addLevel(String name, int[][] map) {
        ArrayList<Pair<Point, Integer>> level = new ArrayList<>();
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[j][i] > 0)
                    level.add(new Pair<>(new Point(j, i), map[j][i]));
            }
        }
        addLevelToFile(name, level);
    }

    public void removeLevel(int index) {
        ArrayList<Level> levels = Deserialize();
        if (levels != null)
            levels.remove(index);
        Serialize(levels);
    }

    public String SerializeToString(ArrayList<Level> levels) {
        String result = "";
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(levels);
            oos.close();
            result = Base64.getEncoder().encodeToString(baos.toByteArray());

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return result;
    }

    private void Serialize(ArrayList<Level> levels) {
        String data = SerializeToString(levels);
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(filename));
            out.write(data);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Level> DeserializeFromString(String s) throws IOException, ClassNotFoundException {
        byte[] data = Base64.getDecoder().decode(s);
        ObjectInputStream ois = new ObjectInputStream(
                new ByteArrayInputStream(data));
        Object o = ois.readObject();
        ois.close();
        return (ArrayList<Level>) o;
    }

    private ArrayList<Level> Deserialize() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line = null;
            if ((line = reader.readLine()) != null) {
                return DeserializeFromString(line);
            }
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
//        try {
//            FileInputStream fis = new FileInputStream(filename);
//            ObjectInputStream ois = new ObjectInputStream(fis);
//            ArrayList<Level> levels = (ArrayList<Level>) ois.readObject();
//            ois.close();
//            fis.close();
//            return levels;
//        } catch (IOException ioe) {
//            ioe.printStackTrace();
//        } catch (ClassNotFoundException c) {
//            System.out.println("Class not found");
//            c.printStackTrace();
//        }
//        return null;
    }


}
