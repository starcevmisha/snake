package SnakeGame;


import SnakeGame.SwingGUI.gameGUI.GameWindowSwing;
import SnakeGame.SwingGUI.menuGUI.StartSwingMenu;
import SnakeGame.javafxGUI.GameWindowFx;
import SnakeGame.serial.Serializer;
import javafx.application.Application;

public class Main implements Runnable {
    public static final int WIDTH = 20;
    public static final int HEIGHT = 20;
    public static final int CELL_SIZE = 20;
    static final int snakeLength = 5;
    private static final int Speed = 150;
    public static Thread gameThread = null;
    public Serializer seriailizer = new Serializer();
    public static Game game;
    public static GUI CurrentGui;
    public static IGameGui gameWindow;
    public static void main(String[] args) {

        Object[] options = {"Swing", "javafx"};
//        int n = JOptionPane.showOptionDialog(null,
//                "Что хотите?",
//                "GUI",
//                JOptionPane.YES_NO_OPTION,
//                JOptionPane.QUESTION_MESSAGE,
//                null,     //do not use a custom Icon
//                options,  //the titles of buttons
//                options[0]);
        int n = 0;
        if (n == 0) {
            CurrentGui = GUI.swing;
            new StartSwingMenu(new Main());
        } else {
            CurrentGui = GUI.javafx;
            gameWindow = new GameWindowFx();
            Application.launch(((GameWindowFx) gameWindow).getClass());
        }

    }

    public void run() {
        game = new Game(this);
        if (CurrentGui == GUI.swing) {
            gameWindow = new GameWindowSwing(game);
        } else {
            gameWindow = new GameWindowFx();
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



