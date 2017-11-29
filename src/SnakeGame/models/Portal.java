package SnakeGame.models;

import SnakeGame.Main;

import java.awt.*;
import java.util.Random;

public class Portal {
    public Point point;
    private Random random = new Random();

    public Portal() {
        point.x = random.nextInt(Main.WIDTH);
        point.y = random.nextInt(Main.HEIGHT);
    }

    public boolean IntersectedWith(Point other) {
        return point.equals(other);
    }
}
