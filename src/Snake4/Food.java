package Snake4;

import java.awt.*;
import java.util.Random;

class Food extends Point {
    private Random random = new Random(34567542);
    private Main game;

    Food() {
        super(18, 10);
    }

    void nextFood() {
        x = random.nextInt(Main.WIDTH);
        y = random.nextInt(Main.HEIGHT);
    }

    boolean isEaten(Point snakeHead) {
        return (snakeHead.getX() == this.getX())
                && (snakeHead.getY() == this.getY());
    }
}
