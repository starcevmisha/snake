package SnakeGame.models;

import SnakeGame.Pair;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;

public class Level implements Serializable {
    public final String name;
    public final ArrayList<Pair<Point, Integer>> map;

    public Level(String name, ArrayList<Pair<Point, Integer>> map) {
        this.name = name;
        this.map = map;
    }

    @Override
    public boolean equals(Object other) {
        return other instanceof Level &&
                ((Level) other).name.equals(name) &&
                ((Level) other).map.containsAll(map) &&
                map.containsAll(((Level) other).map);
    }
}
