package Snake4;

import java.awt.*;
import java.util.ArrayList;

public class Snake{
    private ArrayList<Point> snake = new ArrayList<Point>();
    Direction lastDirection = Direction.Right;


    public Snake(int x, int y, int length, Direction direction) {
        for (int i = 0; i < length; i++) {
            Point point = new Point(x-i, y);
            snake.add(point);
        }
        this.lastDirection = direction;
    }
    public ArrayList<Point> getSnakeBody(){
        return snake;
    }

    public boolean isIntersectWithSnake(int x, int y){
        for (Point point:snake){
            if ((int)point.getX() == x && (int)point.getY() == y)
                return true;
        }
        return false;
    }
    public void extend(Point point){
        snake.add(0, point);
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
        snake.add(0, new Point(x, y));
        snake.remove(snake.size() - 1);
    }
}
