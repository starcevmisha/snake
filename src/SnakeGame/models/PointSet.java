package SnakeGame.models;

import java.awt.*;
import java.util.ArrayList;

public abstract class PointSet {
    private ArrayList<Point> containment = new ArrayList<>();

    public ArrayList<Point> getContainment() {
        return containment;
    }

    public boolean isIntersectWith(Point point) {
        for (Point bodyPoint : containment) {
            if ((int) bodyPoint.getX() == (int) point.getX()
                    && (int) bodyPoint.getY() == (int) point.getY())
                return true;
        }
        return false;
    }
}
