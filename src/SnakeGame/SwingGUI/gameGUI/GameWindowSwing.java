package SnakeGame.SwingGUI.gameGUI;

import SnakeGame.Game;
import SnakeGame.IGameGui;
import SnakeGame.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;

public class GameWindowSwing extends JFrame implements IGameGui {
    private MainLayout mainLayout;
    private InfoLayout infoLayout;

    public GameWindowSwing(Game game) {
        super("SnakeGame");
//      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(Main.WIDTH * Main.CELL_SIZE + 218,
                Main.HEIGHT * Main.CELL_SIZE + 40);
        setLocation(200, 100);
        setResizable(false);
        addKeyListener(new KeyController(game));

        addWindowListener(new WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                Main.gameThread.interrupt();
            }
        });

        mainLayout = new MainLayout(game);
        infoLayout = new InfoLayout(game);
        getContentPane().add(BorderLayout.CENTER, mainLayout);
        getContentPane().add(BorderLayout.EAST, infoLayout);
        setVisible(true);

    }

    public void repaint() {
        mainLayout.repaint();
        infoLayout.repaint();
    }
}
