package SnakeGame.models;

import SnakeGame.Direction;
import SnakeGame.Main;

import java.awt.*;
import java.util.ArrayList;

public class Snake {
    private ArrayList<Point> containment = new ArrayList<>();

    public Snake(int x, int y, int length) {
        for (int i = 0; i < length; i++) {
            Point point = new Point(x - i, y);
            containment.add(point);
        }
    }

    public ArrayList<Point> getContainment() {
        return containment;
    }

    public boolean isLoop() {
        Point head = containment.get(0);
        for (int i = 1; i < containment.size(); i++) {
            if ((int) head.getX() == (int) containment.get(i).getX()
                    && (int) head.getY() == (int) containment.get(i).getY())
                return true;
        }
        return false;
    }

    public void cut() {
        ArrayList<Point> oldBody = containment;
        containment = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            containment.add(oldBody.get(i));
        }
    }

    public boolean isIntersectWith(Point point) {
        for (Point bodyPoint : containment) {
            if ((int) bodyPoint.getX() == (int) point.getX()
                    && (int) bodyPoint.getY() == (int) point.getY())
                return true;
        }
        return false;
    }

    public void extend(Point point) {
        containment.add(0, point);
    }

    public Point move(Direction direction) {
        int x = (int) containment.get(0).getX();
        int y = (int) containment.get(0).getY();
        y += (direction == Direction.Down) ? 1 : ((direction == Direction.Up) ? -1 : 0);
        x += (direction == Direction.Right) ? 1 : ((direction == Direction.Left) ? -1 : 0);
        x = (x >= Main.WIDTH) ? 0 : ((x <= -1) ? Main.WIDTH - 1 : x);
        y = (y >= Main.HEIGHT) ? 0 : ((y <= -1) ? Main.HEIGHT - 1 : y);
        containment.remove(containment.size() - 1);
        Point head = new Point(x, y);
        containment.add(0, head);
        return head;
    }
}


