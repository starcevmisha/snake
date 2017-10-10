package Snake4;


import Snake4.gui.InfoLayout;
import Snake4.gui.MainLayout;

import java.awt.*;

public class Main {
    public static final int WIDTH = 20;
    public static final int HEIGHT = 20;
    public static final int CELL_SIZE = 20;
    public static final int snakeLength = 5;
    Game game;


    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        game = new Game();

        Snake4.gui.Window myWindow = new Snake4.gui.Window(game);
        MainLayout mainLayout = new MainLayout(game);
        InfoLayout infoLayout = new InfoLayout(game);

        //Создание слоёв
        myWindow.getContentPane().add(BorderLayout.CENTER, mainLayout);
        myWindow.getContentPane().add(BorderLayout.EAST, infoLayout);


        while (true) {
            if (!Game.isPaused && !Game.isGameOver)
                game.oneStep();

            mainLayout.repaint();
            infoLayout.repaint();

            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}