package Snake4;

import java.awt.*;
public class MyPoint {
    int x;
    int y;
    Color color = Color.black;

    public MyPoint(int x, int y){
        this.x = x;
        this.y = y;
    }

    int getX() { return x; }
    int getY() { return y; }

    void paint(Graphics g){
        g.setColor(color);
        g.fillRect(x*SnakeGame.CELL_SIZE, y*SnakeGame.CELL_SIZE,
                SnakeGame.CELL_SIZE, SnakeGame.CELL_SIZE);
        g.setColor(Color.white);
        g.drawRect(x*SnakeGame.CELL_SIZE, y*SnakeGame.CELL_SIZE,
                SnakeGame.CELL_SIZE, SnakeGame.CELL_SIZE);
    }
}
