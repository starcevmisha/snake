package SnakeGame.models;

import SnakeGame.Direction;
import SnakeGame.Main;

import java.awt.*;
import java.util.ArrayList;

public class Snake {
    private ArrayList<Point> body = new ArrayList<>();

    public Snake(int x, int y, int length) {
        for (int i = 0; i < length; i++) {
            Point point = new Point(x - i, y);
            body.add(point);
        }
    }

    public ArrayList<Point> getBody() {
        return body;
    }

    public boolean isLoop() {
        Point head = body.get(0);
        for (int i = 1; i < body.size(); i++) {
            if ((int) head.getX() == (int) body.get(i).getX()
                    && (int) head.getY() == (int) body.get(i).getY())
                return true;
        }
        return false;
    }

    public void cut() {
        ArrayList<Point> oldBody = body;
        body = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            body.add(oldBody.get(i));
        }
    }
    public boolean isIntersectWith(Point p) {
        for (Point point : body) {
            if ((int) point.getX() == (int) p.getX()
                    && (int) point.getY() == (int) p.getY())
                return true;
        }
        return false;
    }

    public void extend(Point point) {
        body.add(0, point);
    }

    public Point move(Direction direction) {
        int x = (int) body.get(0).getX();
        int y = (int) body.get(0).getY();

        int shiftY = (direction == Direction.Down) ? 1 : ((direction == Direction.Up) ? -1 : 0);
        int shiftX = (direction == Direction.Right) ? 1 : ((direction == Direction.Left) ? -1 : 0);


        x += shiftX;
        y += shiftY;

        if (x == (int) body.get(1).getX() && y == (int) body.get(1).getY()) {
            return body.get(0);
        }





        x = (x >= Main.WIDTH) ? 0 : ((x <= -1) ? Main.WIDTH - 1 : x);
        y = (y >= Main.HEIGHT) ? 0 : ((y <= -1) ? Main.HEIGHT - 1 : y);


        body.remove(body.size() - 1);
        Point head = new Point(x, y);
        body.add(0, head);
        return head;

    }
}


