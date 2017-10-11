package SnakeGame.gui;

import SnakeGame.Game;
import SnakeGame.Main;

import javax.swing.*;

public class Window extends JFrame {
    public Window(Game game) {
        super("SnakeGame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(Main.WIDTH * Main.CELL_SIZE + 218,
                Main.HEIGHT * Main.CELL_SIZE + 40);
        setLocation(200, 100);
        setResizable(false);

        addKeyListener(new KeyController(game));
    }
}
