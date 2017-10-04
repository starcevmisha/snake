package Snake4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SnakeGame {
    static final int WIDTH = 20;
    static final int HEIGHT = 20;
    static final int CELL_SIZE = 20;
    static boolean isGameOver = false;
    private static boolean isPaused = false;
    private Direction direction = Direction.Right;
    Snake snake;
    Food food;
    int score = 0;


    public static void main(String[] args) {
        new SnakeGame().run();
    }


    private void run() {
        JFrame myWindow = new JFrame("Snake. Score : 0");
        myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myWindow.setSize(WIDTH * CELL_SIZE+218, HEIGHT * CELL_SIZE + 40);
        myWindow.setLocation(200, 100);
        myWindow.setResizable(false);
        myWindow.setVisible(true);//Создание окна

        myWindow.addKeyListener(new KeyAdapter() {//Обработка клавиш
            @Override
            public void keyPressed(KeyEvent e) {
                switch(e.getKeyCode())
                {
                    case KeyEvent.VK_W:
                    case KeyEvent.VK_UP:
                        if (direction!=Direction.Down)
                            direction = Direction.Up;
                        break;

                    case KeyEvent.VK_S:
                    case KeyEvent.VK_DOWN:
                        if (direction!=Direction.Up)
                            direction = Direction.Down;
                        break;

                    case KeyEvent.VK_A:
                    case KeyEvent.VK_LEFT:
                        if (direction!=Direction.Right)
                            direction = Direction.Left;
                        break;

                    case KeyEvent.VK_D:
                    case KeyEvent.VK_RIGHT:
                        if (direction!=Direction.Left)
                            direction = Direction.Right;
                        break;

                    case KeyEvent.VK_P:
                        isPaused = !isPaused;
                        break;

                    case KeyEvent.VK_ENTER:
                        if (isGameOver) {
                            resetGame();
                        }
                        break;

                }
            }
        });


        MainLayout mainLayout = new MainLayout(this);
        InfoLayout infoLayout = new InfoLayout(this);

        myWindow.getContentPane().add(BorderLayout.CENTER, mainLayout);
        myWindow.getContentPane().add(BorderLayout.EAST, infoLayout);//Создание слоёв


        snake = new Snake(10, 10, 5, direction);
        food = new Food();

        while (!isGameOver) {
            if (!isPaused)
                snake.Move(direction);
            Point oldPointFood = new Point((int)food.getX(), (int)food.getY());
            if (food.isEaten(snake)) {
                score += 1;
                snake.extend(oldPointFood);
                myWindow.setTitle("Snake. Score : " + score);
            }
            mainLayout.repaint();
            infoLayout.repaint();
            try {
                Thread.sleep(150);
            } catch (InterruptedException e) { e.printStackTrace(); }
        }

    }
    private void resetGame() {
        snake = new Snake(10, 10, 5, direction);
        food.NextFood(snake);
        isGameOver = false;
    }
}