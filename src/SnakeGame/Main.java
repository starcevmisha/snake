package SnakeGame;


import SnakeGame.gui.InfoLayout;
import SnakeGame.gui.MainLayout;

import java.awt.*;

public class Main {
    public static final int WIDTH = 20;
    public static final int HEIGHT = 20;
    public static final int CELL_SIZE = 20;
    static final int snakeLength = 5;
    private static final int Speed = 150;


    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        Game game = new Game();

        SnakeGame.gui.Window myWindow = new SnakeGame.gui.Window(game);
        MainLayout mainLayout = new MainLayout(game);
        InfoLayout infoLayout = new InfoLayout(game);
        myWindow.getContentPane().add(BorderLayout.CENTER, mainLayout);
        myWindow.getContentPane().add(BorderLayout.EAST, infoLayout);

        while (true) {
            if (!Game.isPaused && !Game.isGameOver)
                game.oneStep();

            mainLayout.repaint();
            infoLayout.repaint();

            try {
                Thread.sleep(Speed);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}