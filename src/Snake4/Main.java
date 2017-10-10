package Snake4;


import java.awt.*;

public class Main {
    static final int WIDTH = 20;
    static final int HEIGHT = 20;
    static final int CELL_SIZE = 20;
    static final int snakeLength = 1;
    Game game;


    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        game = new Game();

        Window myWindow = new Window(game);
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