package SnakeGame.models;

import SnakeGame.Main;

import java.awt.*;
import java.util.Random;

public class Portal {
    public Point point;
    private Random random = new Random();

    public Portal() {
        System.out.println(random.nextInt(Main.WIDTH));
        point = new Point(5, 10);
//                random.nextInt(Main.WIDTH),
//                random.nextInt(Main.HEIGHT));
    }

    public boolean isInersectWith
            (Point other) {
        return point.equals(other);
    }
}
