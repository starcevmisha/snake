package Snake4;

import java.awt.*;
import java.util.Random;

public class Food extends Point {
    Random random = new Random(34567542);

    public Food() {
        super(12, 11);
    }

    public void NextFood(Snake snake) {
        x = random.nextInt(SnakeGame.WIDTH);
        y = random.nextInt(SnakeGame.HEIGHT);
        if (snake.isIntersectWithSnake(x,y))
            NextFood(snake);
    }

    public boolean isEaten(Snake snake) {
        if ((snake.getSnakeBody().get(0).getX() == this.getX())
                && (snake.getSnakeBody().get(0).getY() == this.getY())){
            NextFood(snake);
            return true;
        }
        return false;
    }
}
