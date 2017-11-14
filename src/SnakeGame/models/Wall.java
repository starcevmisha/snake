package SnakeGame.models;


import SnakeGame.Pair;
import SnakeGame.serial.StockLevels;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Wall {

    private static ArrayList<Pair<Point, Integer>> wallList = new ArrayList<>();

    public Wall(int levelNum) {

        if (levelNum != -1) {
            int t = 1;
            Map<Integer, ArrayList<Pair<Point, Integer>>> wallMapDict = new HashMap<>();
            for (Level level : StockLevels.extractLevels()) {
                wallMapDict.put(t, level.map);
                t += 1;
            }

            wallList = wallMapDict.get(levelNum);
//            wallList = new ArrayList<>();
//            for (int i = 0; i < wallMap.length; i++)
//                for (int j = 0; j < wallMap[0].length(); j++)
//                    if (wallMap[i].charAt(j) == '1')
//                        wallList.add(new Pair<>(new Point(j, i), 1));
        }
    }

    public static void setCustomMap(int[][] map) {
        wallList = new ArrayList<>();
        for (int i = 0; i < map.length; i++)
            for (int j = 0; j < map[0].length; j++)
                if (map[j][i] > 0)
                    wallList.add(new Pair<>(new Point(j, i), map[i][j]));
    }

    public boolean isIntersectWith(Point other) {
        for (Pair<Point, Integer> pair : wallList) {
            if ((int) pair.getLeft().getX() == (int) other.getX()
                    && (int) pair.getLeft().getY() == (int) other.getY())
                return true;
        }
        return false;
    }

    public ArrayList<Pair<Point, Integer>> getWallMap() {
        return wallList;
    }
}
