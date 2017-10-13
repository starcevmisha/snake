package SnakeGame;


import SnakeGame.gameGUI.GameWindow;
import SnakeGame.gameGUI.InfoLayout;
import SnakeGame.gameGUI.MainLayout;
import SnakeGame.menuGUI.StartMenu;

import java.awt.*;

public class Main {
    public static final int WIDTH = 20;
    public static final int HEIGHT = 20;
    public static final int CELL_SIZE = 20;
    static final int snakeLength = 5;
    private static final int Speed = 150;
    public static STATE State = STATE.GAME;

    public void run() {
        Game game = new Game();
        GameWindow gameWindow = new GameWindow(game);
        MainLayout mainLayout = new MainLayout(game);
        InfoLayout infoLayout = new InfoLayout(game);
        gameWindow.getContentPane().add(BorderLayout.CENTER, mainLayout);
        gameWindow.getContentPane().add(BorderLayout.EAST, infoLayout);
//        gameWindow.setVisible(true);
        StartMenu startMenu = new StartMenu(gameWindow);


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

    public static void main(String[] args) {
        new Main().run();
    }

    public enum STATE {
        MENU,
        GAME
    }
}

