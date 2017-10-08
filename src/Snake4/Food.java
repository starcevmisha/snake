package Snake4;

import java.awt.*;
import java.util.Random;

class Food extends Point {
    private Random random = new Random(34567542);
    private SnakeGame game;

    Food(SnakeGame game) {
        super(18, 10);
        this.game = game;
    }

    void nextFood() {
        x = random.nextInt(SnakeGame.WIDTH);
        y = random.nextInt(SnakeGame.HEIGHT);
        if (game.snake.isIntersectWith(new Point(x, y))
                || game.wall.isIntersectWith(new Point(x, y)))
            nextFood();
    }

    boolean isEaten(Point snakeHead) {
        boolean gotFood = (snakeHead.getX() == this.getX())
                && (snakeHead.getY() == this.getY());
        if (gotFood)
            nextFood();
        return gotFood;
    }
}
