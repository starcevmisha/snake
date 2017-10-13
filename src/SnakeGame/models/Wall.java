package SnakeGame.models;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Wall {
    String[] wallMap1 = {
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
    String[] wallMap2 = {
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
    private ArrayList<Point> wallList = new ArrayList<>();
    Map wallMapDict = new HashMap<Integer, String[]>() {{
        put(1, wallMap1);
        put(2, wallMap2);
    }};
    int a = 3;



    //TODO редактор уровней, яблоки рандома с разными очками, супер еда
    public Wall(int level) {
        String[] wallMap = (String[]) wallMapDict.get(level);
        for (int i = 0; i < wallMap.length; i++)
            for (int j = 0; j < wallMap[0].length(); j++)
                if (wallMap[i].charAt(j) == '1')
                    wallList.add(new Point(j, i));
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
