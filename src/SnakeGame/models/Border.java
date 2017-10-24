package SnakeGame.models;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Border {
    private static boolean isSet = false;
    private static ArrayList<Point> borderList = new ArrayList<>();
    private String[] borderMap1 = {
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
    private String[] borderMap2 = {
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
    private String[] borderMap3 = {
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

    public Border(int level) {
        if (!isSet) {
            Map wallMapDict = new HashMap<Integer, String[]>() {{
                put(1, borderMap1);
                put(2, borderMap2);
                put(3, borderMap3);
            }};
            String[] wallMap = (String[]) wallMapDict.get(level);
            for (int i = 0; i < wallMap.length; i++)
                for (int j = 0; j < wallMap[0].length(); j++)
                    if (wallMap[i].charAt(j) == '1')
                        borderList.add(new Point(j, i));
        }
    }

    public static void setCustomMap(boolean[][] map) {
        for (int i = 0; i < map.length; i++)
            for (int j = 0; j < map[0].length; j++)
                if (map[j][i])
                    borderList.add(new Point(j, i));
        isSet = true;
    }

    public boolean isIntersectWith(Point point) {
        for (Point bodyPoint : borderList) {
            if ((int) bodyPoint.getX() == (int) point.getX()
                    && (int) bodyPoint.getY() == (int) point.getY())
                return true;
        }
        return false;
    }

    public ArrayList<Point> getBorderList() {
        return borderList;
    }
}
