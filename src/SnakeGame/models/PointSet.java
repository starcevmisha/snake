package SnakeGame.models;

import java.awt.*;
import java.util.ArrayList;

public abstract class PointSet {
    ArrayList<Point> body = new ArrayList<>();

    public ArrayList<Point> getBody() {
        return body;
    }

    public boolean isIntersectWith(Point other) {
        for (Point point : body) {
            if ((int) point.getX() == (int) other.getX()
                    && (int) point.getY() == (int) other.getY())
                return true;
        }
        return false;
    }
}
