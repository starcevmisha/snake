package SnakeGame;


import SnakeGame.gameGUI.GameWindow;
import SnakeGame.gameGUI.InfoLayout;
import SnakeGame.gameGUI.MainLayout;
import SnakeGame.menuGUI.StartMenu;
import SnakeGame.serial.Serializer;

import java.awt.*;

public class Main implements Runnable {
    public static final int WIDTH = 20;
    public static final int HEIGHT = 20;
    public static final int CELL_SIZE = 20;
    static final int snakeLength = 5;
    private static final int Speed = 150;
    public static Thread gameThread = null;
    public Serializer seriailizer = new Serializer();
    public static void main(String[] args) {

        new StartMenu(new Main());
    }

    public void run() {
        Game game = new Game(this);
        GameWindow gameWindow = new GameWindow(game);
        MainLayout mainLayout = new MainLayout(game);
        InfoLayout infoLayout = new InfoLayout(game);
        gameWindow.getContentPane().add(BorderLayout.CENTER, mainLayout);
        gameWindow.getContentPane().add(BorderLayout.EAST, infoLayout);
        gameWindow.setVisible(true);

        while (true) {
            if (!Game.isPaused && !Game.isGameOver)
                game.oneStep();
            mainLayout.repaint();
            infoLayout.repaint();
            try {
                Thread.sleep(Speed);
            } catch (InterruptedException exception) {
                Thread.currentThread().interrupt();
                return;
            } catch (Exception exception) {
                break;
            }
        }
    }
}

