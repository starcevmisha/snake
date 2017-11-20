package SnakeGame;


import SnakeGame.SwingGUI.gameGUI.GameWindow;
import SnakeGame.SwingGUI.gameGUI.InfoLayout;
import SnakeGame.SwingGUI.gameGUI.MainLayout;
import SnakeGame.SwingGUI.menuGUI.StartSwingMenu;
import SnakeGame.serial.Serializer;

import javax.swing.*;
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

        Object[] options = {"Swing", "SWT"};
        int n = JOptionPane.showOptionDialog(null,
                "Что хотите?",
                "GUI",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,     //do not use a custom Icon
                options,  //the titles of buttons
                options[0]);
        if (n == 0)
            new StartSwingMenu(new Main());
        else
            System.out.println("Not Implemented");
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

