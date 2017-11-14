package SnakeGame.menuGUI.LevelCreator;


import SnakeGame.Game;
import SnakeGame.Main;
import SnakeGame.serial.StockLevels;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

class ButtonLayout extends JPanel {
    ButtonLayout(LevelCreatorWindow levelCreatorWindow, Main main) {
        Font MEDIUM_FONT = new Font("Tahoma", Font.BOLD, 16);
        setPreferredSize(new Dimension(200, 800));
        setBackground(Color.BLACK);
        setLayout(null);

        int startPosY = 90;

        JButton startButton = new JButton("Start Game");
        startButton.setPreferredSize(new Dimension(140, 40));
        startButton.setBounds(30, startPosY, 140, 40);
        startButton.setBackground(Color.black);
        startButton.setBorder(new LineBorder(Color.green));
        startButton.setFont(MEDIUM_FONT);
        startButton.setForeground(Color.green);
        startButton.setOpaque(true);
        startButton.addActionListener(e -> {
            Game.levelNum = -1;
            Game.wall.setCustomMap(levelCreatorWindow.map);
            Thread myThread = new Thread(main);
            myThread.start();
            levelCreatorWindow.setVisible(false);
        });
        add(startButton);

        JButton saveButton = new JButton("Save Level");
        saveButton.setPreferredSize(new Dimension(140, 40));
        saveButton.setBounds(30, startPosY + 70, 140, 40);
        saveButton.setBackground(Color.black);
        saveButton.setBorder(new LineBorder(Color.green));
        saveButton.setFont(MEDIUM_FONT);
        saveButton.setForeground(Color.green);
        saveButton.setOpaque(true);
        saveButton.addActionListener(e -> {
            String levelName = JOptionPane.showInputDialog("Enter Level Name");
            StockLevels.addLevel(levelName, levelCreatorWindow.map);
        });

        add(saveButton);

        JButton exitButton = new JButton("Close Game");
        exitButton.setPreferredSize(new Dimension(140, 40));
        exitButton.setBackground(Color.black);
        exitButton.setBounds(30, startPosY + 140, 140, 40);
        exitButton.setBorder(new LineBorder(Color.green));
        exitButton.setFont(MEDIUM_FONT);
        exitButton.setForeground(Color.green);
        exitButton.setOpaque(true);
        exitButton.addActionListener(e -> System.exit(0));
        add(exitButton);
    }
}
