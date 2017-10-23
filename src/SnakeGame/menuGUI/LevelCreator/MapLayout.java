package SnakeGame.menuGUI.LevelCreator;

import SnakeGame.Main;

import javax.swing.*;
import java.awt.*;

public class MapLayout extends JPanel {
    private boolean[][] map;

    MapLayout(boolean[][] map) {
        this.map = map;
        setBackground(Color.BLACK);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (int x = 0; x < map.length; x++) {
            for (int y = 0; y < map[0].length; y++) {
                if (map[x][y]) {
                    g.setColor(Color.LIGHT_GRAY);
                    g.fillRect(x * Main.CELL_SIZE, y * Main.CELL_SIZE,
                            Main.CELL_SIZE, Main.CELL_SIZE);
                }
            }
        }
        for (int x = 0; x < Main.WIDTH; x++) {//Рисуем сетку
            for (int y = 0; y < Main.HEIGHT; y++) {
                g.setColor(Color.DARK_GRAY);
                g.drawRect(x * Main.CELL_SIZE, y * Main.CELL_SIZE,
                        Main.CELL_SIZE, Main.CELL_SIZE);
            }
        }
    }
}
