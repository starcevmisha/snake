package SnakeGame.models;

import SnakeGame.Direction;
import SnakeGame.Main;

import java.awt.*;
import java.util.ArrayList;

public class Snake {
    private ArrayList<Point> body = new ArrayList<>();
    public int initialSize = 5;

    public Snake(int x, int y, int length) {
        initialSize = length;
        for (int i = 0; i < 1; i++) {
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

    public boolean isIntersectWith(Point other) {
        for (Point point : body)
            if (point.equals(other))
                return true;
        return false;
    }

    public void extend(Point point) {
        body.add(0, point);
        initialSize = body.size();
    }

    public void growUp() {
        if (body.size() <= initialSize) {
            body.add(0, body.get(0));
        }

    }

    public Point move(Direction direction) {
        int x = (int) body.get(0).getX();
        int y = (int) body.get(0).getY();

        int shiftY = (direction == Direction.Down) ? 1 :
                ((direction == Direction.Up) ? -1 : 0);
        int shiftX = (direction == Direction.Right) ? 1 :
                ((direction == Direction.Left) ? -1 : 0);

        x += shiftX;
        y += shiftY;

//        if (x == (int) body.get(1).getX() && y == (int) body.get(1).getY()) {
//            return body.get(0);
//        }

        x = (x >= Main.WIDTH) ? 0 : ((x <= -1) ? Main.WIDTH - 1 : x);
        y = (y >= Main.HEIGHT) ? 0 : ((y <= -1) ? Main.HEIGHT - 1 : y);

        body.remove(body.size() - 1);
        Point head = new Point(x, y);
        body.add(0, head);
        return head;
    }

    public Boolean AppearFromPortal(Point portal) {
        if (body.size() < initialSize) {
            //snake.move(direction);
            // если хвост змеи прямо в портале, увеличим хвост в соседнюю клетку
            // после snake.move она встанет на портал
            if (body.get(body.size() - 1).equals(portal))
                body.add(new Point(portal.x - 1, portal.y));
            else body.add(portal);
            return true;
        }
        return false;
    }

    public void RemoveHead() {
        body.remove(0);
    }
}


