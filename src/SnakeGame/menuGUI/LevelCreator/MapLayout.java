package SnakeGame.menuGUI.LevelCreator;

import SnakeGame.Main;

import javax.swing.*;
import java.awt.*;

public class MapLayout extends JPanel {
    private int[][] map;

    MapLayout(int[][] map) {
        this.map = map;
        setBackground(Color.BLACK);
    }

    @Override
    public void paint(Graphics canvas) {
        super.paint(canvas);
        for (int x = 0; x < map.length; x++) {
            for (int y = 0; y < map[0].length; y++) {
                if (map[x][y] > 0) {
                    canvas.setColor(Color.LIGHT_GRAY);
                    canvas.fillRect(x * Main.CELL_SIZE, y * Main.CELL_SIZE,
                            Main.CELL_SIZE, Main.CELL_SIZE);
                }
            }
        }
        for (int x = 0; x < Main.WIDTH; x++) {
            //Рисуем сетку
            for (int y = 0; y < Main.HEIGHT; y++) {
                canvas.setColor(Color.DARK_GRAY);
                canvas.drawRect(x * Main.CELL_SIZE, y * Main.CELL_SIZE,
                        Main.CELL_SIZE, Main.CELL_SIZE);
            }
        }
    }
}
