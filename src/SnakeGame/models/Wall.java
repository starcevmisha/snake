package SnakeGame.models;


import SnakeGame.serial.JsonLevels;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Wall {
    private static boolean isSet = false;

    private static ArrayList<Point> wallList = new ArrayList<>();

    public Wall(int levelNum) {
        if (!isSet) {
            int t = 1;
            Map<Integer, String[]> wallMapDict = new HashMap<>();
            for (JsonLevels.Level level : JsonLevels.extractLevels()) {
                wallMapDict.put(t, level.map);
                t += 1;
            }

            String[] wallMap = wallMapDict.get(levelNum);
            wallList = new ArrayList<>();
            for (int i = 0; i < wallMap.length; i++)
                for (int j = 0; j < wallMap[0].length(); j++)
                    if (wallMap[i].charAt(j) == '1')
                        wallList.add(new Point(j, i));
        }
    }

    public static void setCustomMap(boolean[][] map) {
        wallList = new ArrayList<>();
        for (int i = 0; i < map.length; i++)
            for (int j = 0; j < map[0].length; j++)
                if (map[j][i])
                    wallList.add(new Point(j, i));
        isSet = true;
    }

    public boolean isIntersectWith(Point other) {
        for (Point point : wallList) {
            if ((int) point.getX() == (int) other.getX()
                    && (int) point.getY() == (int) other.getY())
                return true;
        }
        return false;
    }

    public ArrayList<Point> getWallMap() {
        return wallList;
    }
}
