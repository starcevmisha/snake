package SnakeGame.models;

import java.awt.*;
import java.util.ArrayList;

public abstract class PointSequence {
    ArrayList<Point> body = new ArrayList<>();

    public abstract boolean isLoop();

    public ArrayList<Point> getBody() {
        return body;
    }

    public boolean isIntersectWith(Point point) {
        for (Point bodyPoint : body) {
            if ((int) bodyPoint.getX() == (int) point.getX()
                    && (int) bodyPoint.getY() == (int) point.getY())
                return true;
        }
        return false;
    }

    public void extend(Point point) {
        body.add(0, point);
    }

    public void cut(int length) {
        ArrayList<Point> oldBody = body;
        body = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            body.add(oldBody.get(i));
        }
    }
}
