package SnakeGame.models;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Wall {
    private static boolean isSet = false;
    private String[] wallMap1 = {
            "11100000000000000111",
            "10000000000000000001",
            "10000000000000000001",
            "00000000000000000000",
            "00000000000000000000",
            "00000000000000000000",
            "00000000000000000000",
            "00000000000000000000",
            "00000011111111100000",
            "00000000000000000000",
            "00000000000000000000",
            "00000000000000000000",
            "00000011111111100000",
            "00000000000000000000",
            "00000000000000000000",
            "00000000000000000000",
            "00000000000000000000",
            "10000000000000000001",
            "10000000000000000001",
            "11100000000000000111"
    };
    private String[] wallMap2 = {
            "11100000000000000111",
            "10000000000000000001",
            "10000000000000000001",
            "00000000000000000000",
            "00000000000000000000",
            "00000000000000000000",
            "00000000000000000000",
            "00000000000000000000",
            "00000000000000000000",
            "00000000000000000000",
            "00000000000000000000",
            "00000000000000000000",
            "00000000000000000000",
            "00000000000000000000",
            "00000000000000000000",
            "00000000000000000000",
            "00000000000000000000",
            "10000000000000000001",
            "10000000000000000001",
            "11100000000000000111"
    };
    private String[] wallMap3 = {
            "11111111111111111111",
            "00000000000000000000",
            "00010000000000001000",
            "00111000000000011100",
            "00010000000000001000",
            "00000000000000000000",
            "00000000000000000000",
            "00000000000000000000",
            "00000000000000000000",
            "00000000000000000000",
            "00000000000000000000",
            "00000000000000000000",
            "00000000000000000000",
            "00000000000000000000",
            "00000000000000000000",
            "00010000000000001000",
            "00111000000000011100",
            "00010000000000001000",
            "00000000000000000000",
            "11111111111111111111"
    };
    private static ArrayList<Point> wallList = new ArrayList<>();

    public Wall(int level) {
        if (!isSet) {
            Map wallMapDict = new HashMap<Integer, String[]>() {{
                put(1, wallMap1);
                put(2, wallMap2);
                put(3, wallMap3);
            }};
            String[] wallMap = (String[]) wallMapDict.get(level);
            for (int i = 0; i < wallMap.length; i++)
                for (int j = 0; j < wallMap[0].length(); j++)
                    if (wallMap[i].charAt(j) == '1')
                        wallList.add(new Point(j, i));
        }
    }

    public static void setCustomMap(boolean[][] map) {
        for (int i = 0; i < map.length; i++)
            for (int j = 0; j < map[0].length; j++)
                if (map[j][i])
                    wallList.add(new Point(j, i));
        isSet = true;
    }

    public boolean isIntersectWith(Point p) {
        for (Point point : wallList) {
            if ((int) point.getX() == (int) p.getX()
                    && (int) point.getY() == (int) p.getY())
                return true;
        }
        return false;
    }

    public ArrayList<Point> getWallMap() {
        return wallList;
    }
}
