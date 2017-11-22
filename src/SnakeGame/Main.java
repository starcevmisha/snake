package SnakeGame;


import SnakeGame.SwingGUI.gameGUI.GameWindowSwing;
import SnakeGame.SwingGUI.menuGUI.StartSwingMenu;
import SnakeGame.serial.Serializer;

import javax.swing.*;

public class Main implements Runnable {
    public static final int WIDTH = 20;
    public static final int HEIGHT = 20;
    public static final int CELL_SIZE = 20;
    static final int snakeLength = 5;
    private static final int Speed = 150;
    public static Thread gameThread = null;
    public Serializer seriailizer = new Serializer();
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
        if (n == 0)
            new StartSwingMenu(new Main());
        else
            System.out.println("Not Implemented");
    }

    public void run() {
        Game game = new Game(this);
        GameWindowSwing gameWindow = new GameWindowSwing(game);


        while (true) {
            if (!Game.isPaused && !Game.isGameOver)
                game.oneStep();
            gameWindow.Repaint();
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

