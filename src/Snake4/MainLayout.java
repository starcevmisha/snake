package Snake4;

import javax.swing.*;
import java.awt.*;

public class MainLayout extends JPanel {
    SnakeGame game;
    public MainLayout(SnakeGame game){
        this.game = game;
        setPreferredSize(new Dimension(game.WIDTH * game.CELL_SIZE, game.HEIGHT * game.CELL_SIZE));
        setBackground(Color.BLACK);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        for (Point point : game.snake.getSnakeBody()) {
            paint_point(g, point, Color.black);
        }
        paint_point(g, game.food, Color.magenta);

        if (game.isgameOver) {
            g.setColor(Color.red);
            g.setFont(new Font("Arial", Font.BOLD, 40));
            FontMetrics fm = g.getFontMetrics();
            g.drawString("GAME OVER", (game.WIDTH * game.CELL_SIZE - fm.stringWidth("GAME OVER"))/2,
                    (game.HEIGHT * game.CELL_SIZE)/2);
        }
    }

    void paint_point(Graphics g, Point p, Color color){
        g.setColor(color);
        g.fillRect(p.x*SnakeGame.CELL_SIZE, p.y*SnakeGame.CELL_SIZE,
                SnakeGame.CELL_SIZE, SnakeGame.CELL_SIZE);
        g.setColor(Color.white);
        g.drawRect(p.x*SnakeGame.CELL_SIZE, p.y*SnakeGame.CELL_SIZE,
                SnakeGame.CELL_SIZE, SnakeGame.CELL_SIZE);
    }
}
