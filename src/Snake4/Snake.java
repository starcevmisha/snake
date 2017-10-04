package Snake4;

import java.awt.*;
import java.util.ArrayList;

class Snake {
    private ArrayList<Point> snake = new ArrayList<>();
    private SnakeGame game;

    Snake(int x, int y, int length, SnakeGame game) {
        this.game = game;
        for (int i = 0; i < length; i++) {
            Point point = new Point(x-i, y);
            snake.add(point);
        }
    }

    ArrayList<Point> getSnakeBody() {
        return snake;
    }

    boolean isIntersectWith(Point p) {
        for (Point point:snake){
            if ((int) point.getX() == (int) p.getX()
                    && (int) point.getY() == (int) p.getY())
                return true;
        }
        return false;
    }

    private void extend(Point point) {
        snake.add(0, point);
    }

    void Move() {
        int x = (int)snake.get(0).getX();
        int y = (int)snake.get(0).getY();
        if (game.direction == Direction.Up)
            y--;
        if (game.direction == Direction.Right)
            x++;
        if (game.direction == Direction.Down)
            y++;
        if (game.direction == Direction.Left)
            x--;
        if (x >= SnakeGame.WIDTH)
            x = 0;
        if (x <= -1)
            x = SnakeGame.WIDTH - 1;
        if (y >= SnakeGame.HEIGHT)
            y = 0;
        if (y <= -1)
            y = SnakeGame.HEIGHT - 1;

        Point head = new Point(x, y);
        SnakeGame.isGameOver =
                isIntersectWith(head) || game.wall.isIntersectWith(head);


        Point oldPointFood = new Point((int) game.food.getX(), (int) game.food.getY());
        if (game.food.isEaten(head)) {
            game.score += 1;
            extend(oldPointFood);
        }

        snake.add(0, head);
        snake.remove(snake.size() - 1);


    }
}
