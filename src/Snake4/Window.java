package Snake4;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

class Window extends JFrame {
    Window(SnakeGame game) {
        super("Snake");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(SnakeGame.WIDTH * SnakeGame.CELL_SIZE + 218,
                SnakeGame.HEIGHT * SnakeGame.CELL_SIZE + 40);
        setLocation(200, 100);
        setResizable(false);
        setVisible(true);

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_W:
                    case KeyEvent.VK_UP:
                        if (game.direction != Direction.Down)
                            game.direction = Direction.Up;
                        break;

                    case KeyEvent.VK_S:
                    case KeyEvent.VK_DOWN:
                        if (game.direction != Direction.Up)
                            game.direction = Direction.Down;
                        break;

                    case KeyEvent.VK_A:
                    case KeyEvent.VK_LEFT:
                        if (game.direction != Direction.Right)
                            game.direction = Direction.Left;
                        break;

                    case KeyEvent.VK_D:
                    case KeyEvent.VK_RIGHT:
                        if (game.direction != Direction.Left)
                            game.direction = Direction.Right;
                        break;

                    case KeyEvent.VK_P:
                        SnakeGame.isPaused = !SnakeGame.isPaused;
                        break;

                    case KeyEvent.VK_ENTER:
                        if (SnakeGame.isGameOver) {
                            game.resetGame();
                        }
                        break;
                }
            }
        });
    }
}
