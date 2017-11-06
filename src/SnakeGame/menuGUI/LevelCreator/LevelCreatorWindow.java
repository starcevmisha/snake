package SnakeGame.menuGUI.LevelCreator;

import SnakeGame.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LevelCreatorWindow extends JFrame {
    boolean[][] map;

    public LevelCreatorWindow(Main main) {
        super("Create Level");
        setSize(Main.WIDTH * Main.CELL_SIZE + 218,
                Main.HEIGHT * Main.CELL_SIZE + 40);
        setLocation(200, 100);

        map = new boolean[Main.WIDTH][Main.HEIGHT];

        ButtonLayout buttonLayout = new ButtonLayout(this, main);

        getContentPane().add(BorderLayout.EAST, buttonLayout);
        MapLayout mapLayout = new MapLayout(map);
        getContentPane().add(BorderLayout.CENTER, mapLayout);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int xKey = (e.getX() - 8) / Main.CELL_SIZE;
                int yKey = (e.getY() - 31) / Main.CELL_SIZE;
                map[xKey][yKey] =
                        !map[xKey][yKey];
                mapLayout.repaint();
            }
        });

        setVisible(true);
    }
}