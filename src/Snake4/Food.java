package Snake4;

import java.awt.*;
import java.util.Random;

public class Food extends MyPoint {
    Random random;
    public Food() {
        super(10, 10);
        this.color  = Color.magenta;
    }

    public void NextFood(){
        x =random.nextInt(SnakeGame.WIDTH);
        y = random.nextInt(SnakeGame.HEIGHT);
    }
}
