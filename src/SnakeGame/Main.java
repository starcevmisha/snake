package SnakeGame;


import SnakeGame.SwingGUI.gameGUI.GameWindowSwing;
import SnakeGame.SwingGUI.menuGUI.StartSwingMenu;
import SnakeGame.javafxGUI.GameWindowFx;
import SnakeGame.serial.Serializer;
import javafx.application.Application;

import javax.swing.*;

public class Main implements Runnable {
    public static final int WIDTH = 20;
    public static final int HEIGHT = 20;
    public static final int CELL_SIZE = 20;
    static final int snakeLength = 5;
    private static final int Speed = 150;
    public static Thread gameThread = null;
    public Serializer seriailizer = new Serializer();
    public static GUI CurrentGui;
    public static void main(String[] args) {

        Object[] options = {"Swing", "javafx"};
        int n = JOptionPane.showOptionDialog(null,
                "Что хотите?",
                "GUI",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,     //do not use a custom Icon
                options,  //the titles of buttons
                options[0]);
        if (n == 0) {
            CurrentGui = GUI.swing;
            new StartSwingMenu(new Main());
        } else {
            CurrentGui = GUI.javafx;
            Main.gameThread = new Thread(new Main());
            Main.gameThread.start();

        }
    }

    public void run() {
        IGameGui gameWindow;
        Game game = new Game(this);
        if (CurrentGui == GUI.swing) {
            gameWindow = new GameWindowSwing(game);
        } else {
            gameWindow = new GameWindowFx();
            ((GameWindowFx) gameWindow).Settings(game);
            Application.launch(((GameWindowFx) gameWindow).getClass());
        }


        while (true) {
            if (!Game.isPaused && !Game.isGameOver)
                game.oneStep();
            gameWindow.repaint();
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



