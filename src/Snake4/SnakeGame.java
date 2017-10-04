package Snake4;


import java.awt.*;

public class SnakeGame {
    static final int WIDTH = 20;
    static final int HEIGHT = 20;
    static final int CELL_SIZE = 20;
    static boolean isGameOver = false;
    static boolean isPaused = false;
    Direction direction = Direction.Right;
    Snake snake;
    Food food;
    Wall wall;
    int score = 0;


    public static void main(String[] args) {

        new SnakeGame().run();
    }


    private void run() {
        Window myWindow = new Window(this);
        MainLayout mainLayout = new MainLayout(this);
        InfoLayout infoLayout = new InfoLayout(this);

        myWindow.getContentPane().add(BorderLayout.CENTER, mainLayout);
        myWindow.getContentPane().add(BorderLayout.EAST, infoLayout);//Создание слоёв


        snake = new Snake(10, 10, 5, direction);
        food = new Food();

        while (true) {
            if (!isPaused && !isGameOver)
                snake.Move(direction);

            Point oldPointFood = new Point((int)food.getX(), (int)food.getY());
            if (food.isEaten(snake)) {
                score += 1;
                snake.extend(oldPointFood);
            }

            mainLayout.repaint();
            infoLayout.repaint();

            try {
                Thread.sleep(150);
            } catch (InterruptedException e) { e.printStackTrace(); }
        }

    }

    void resetGame() {
        direction = Direction.Right;
        snake = new Snake(10, 10, 5, direction);
        score = 0;
        food.nextFood(snake);
        isGameOver = false;
    }
}