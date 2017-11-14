package SnakeGame.models;


import SnakeGame.serial.StockLevels;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Wall extends PointSet {
    public Wall(int levelNum) {
        if (levelNum != -1) {
            int t = 1;
            Map<Integer, String[]> wallMapDict = new HashMap<>();
            for (Level level : StockLevels.extractLevels()) {
                wallMapDict.put(t, level.map);
                t += 1;
            }

            String[] wallMap = wallMapDict.get(levelNum);
            body = new ArrayList<>();
            for (int i = 0; i < wallMap.length; i++)
                for (int j = 0; j < wallMap[0].length(); j++)
                    if (wallMap[i].charAt(j) == '1')
                        body.add(new Point(j, i));
        }
    }

    public void setCustomMap(boolean[][] map) {
        body = new ArrayList<>();
        for (int i = 0; i < map.length; i++)
            for (int j = 0; j < map[0].length; j++)
                if (map[j][i])
                    body.add(new Point(j, i));
    }
}
