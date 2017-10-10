package SnakeGame.models;

import SnakeGame.Direction;
import SnakeGame.Main;

import java.awt.*;
import java.util.ArrayList;

public class Snake {
    private ArrayList<Point> snake = new ArrayList<>();

    public Snake(int x, int y, int length) {
        for (int i = 0; i < length; i++) {
            Point point = new Point(x-i, y);
            snake.add(point);
        }
    }

    public ArrayList<Point> getSnakeBody() {
        return snake;
    }

    public boolean isIntersectWith(Point p) {
        for (Point point:snake){
            if ((int) point.getX() == (int) p.getX()
                    && (int) point.getY() == (int) p.getY())
                return true;
        }
        return false;
    }

    public void extend(Point point) {
        snake.add(0, point);
    }

    public Point newHeadCoordinates(Direction direction) {
        int x = (int)snake.get(0).getX();
        int y = (int)snake.get(0).getY();
        y += (direction == Direction.Down) ? 1 : ((direction == Direction.Up) ? -1 : 0);
        x += (direction == Direction.Right) ? 1 : ((direction == Direction.Left) ? -1 : 0);
        x = (x >= Main.WIDTH) ? 0 : ((x <= -1) ? Main.WIDTH - 1 : x);
        y = (y >= Main.HEIGHT) ? 0 : ((y <= -1) ? Main.HEIGHT - 1 : y);
        snake.remove(snake.size() - 1);
        Point head = new Point(x, y);//Head coordinates
        return head;
    }

    public void move(Point head) {
        snake.add(0, head);
    }
}
