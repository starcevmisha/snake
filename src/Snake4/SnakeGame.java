package Snake4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SnakeGame {
    static final int WIDTH = 30;
    static final int HEIGHT = 30;
    static final int CELL_SIZE = 20;
    static boolean isgameOver = false;
    private Direction direction = Direction.Right;
    public static void main(String[] args) {
        new SnakeGame().run();
    }
    public Snake snake;
    public Food food;

    void run(){
        JFrame myWindow = new JFrame("Snake");
        myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myWindow.setSize(WIDTH * CELL_SIZE+18, HEIGHT * CELL_SIZE + 28);
        myWindow.setLocation(200, 100);
        myWindow.setResizable(false);
        myWindow.setVisible(true);

        myWindow.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch(e.getKeyCode())
                {
                    case KeyEvent.VK_W:
                    case KeyEvent.VK_UP:
                        direction = Direction.Up;
                        break;

                    case KeyEvent.VK_S:
                    case KeyEvent.VK_DOWN:
                        direction = Direction.Down;
                        break;

                    case KeyEvent.VK_A:
                    case KeyEvent.VK_LEFT:
                        direction = Direction.Left;
                        break;

                    case KeyEvent.VK_D:
                    case KeyEvent.VK_RIGHT:
                        direction = Direction.Right;
                        break;
                }
            }
        });

        Layout layout = new Layout();
        layout.setBackground(Color.yellow);

        myWindow.getContentPane().add(BorderLayout.CENTER, layout);


        snake = new Snake(10, 10, 5, direction);
        food = new Food();
        while (!isgameOver){
            snake.Move(direction);
            layout.repaint();
            try {
                Thread.sleep(150);
            } catch (InterruptedException e) { e.printStackTrace(); }
        }


    }
    public class Layout extends JPanel {
        @Override
        public void paint(Graphics g) {
            super.paint(g);
            snake.paint(g);
            food.paint(g);
        }
    }

}
