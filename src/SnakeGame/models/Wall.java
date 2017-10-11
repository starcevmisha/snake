package SnakeGame.models;

import java.awt.*;
import java.util.ArrayList;

public class Wall {

    private ArrayList<Point> wallList = new ArrayList<>();

    //TODO редактор уровней, яблоки рандома с разными очками, супер еда
    public Wall() {
        String[] wallMap = {
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
