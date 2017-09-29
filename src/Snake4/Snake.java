package Snake4;

import java.awt.*;
import java.util.ArrayList;

public class Snake{
    ArrayList<MyPoint> snake = new ArrayList<MyPoint>();
    Direction lastDirection = Direction.Right;


    public Snake(int x, int y, int length, Direction direction) {
        for (int i = 0; i < length; i++) {
            MyPoint point = new MyPoint(x-i, y);
            snake.add(point);
        }
        this.lastDirection = direction;
    }

    public boolean isIntersectWithSnake(int x, int y){
        for (MyPoint point:snake){
            if (point.getX() == x && point.getY() == y)
                return true;
        }
        return false;
    }

    public void Move(Direction direction){
        int x = (int)snake.get(0).getX();
        int y = (int)snake.get(0).getY();
        if(direction == Direction.Up && lastDirection != Direction.Down)
            y--;
        if (direction == Direction.Right && lastDirection != Direction.Left)
            x++;
        if (direction == Direction.Down && lastDirection != Direction.Up)
            y++;
        if (direction == Direction.Left && lastDirection != Direction.Right)
            x--;
        this.lastDirection = direction;
        if (x >= SnakeGame.WIDTH)
            x = 0;
        if (x <= -1)
            x = SnakeGame.WIDTH - 1;
        if (y >= SnakeGame.HEIGHT)
            y = 0;
        if (y <= -1)
            y = SnakeGame.HEIGHT - 1;
        SnakeGame.isgameOver = isIntersectWithSnake(x,y);
        snake.add(0, new MyPoint(x, y));
        snake.remove(snake.size() - 1);
    }

    void paint(Graphics g) {
        for (MyPoint point : snake) {
            point.paint(g);
        }
    }

}
