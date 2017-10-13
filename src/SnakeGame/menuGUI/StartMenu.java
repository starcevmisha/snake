package SnakeGame.menuGUI;


import SnakeGame.Main;
import SnakeGame.gameGUI.GameWindow;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class StartMenu extends JFrame {
    public StartMenu(GameWindow gameWindow) {
        super("MENU");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocation(200, 100);

        Font LARGE_FONT = new Font("Tahoma", Font.BOLD, 35);
        Font MEDIUM_FONT = new Font("Tahoma", Font.BOLD, 16);

        JLabel topLabel = new JLabel("The Snake Game");
        topLabel.setOpaque(true);
        topLabel.setFont(LARGE_FONT);
        topLabel.setHorizontalAlignment(JLabel.CENTER);
        topLabel.setForeground(Color.GREEN);
        topLabel.setBackground(Color.black);
        getContentPane().add(BorderLayout.NORTH, topLabel);

        ButtonLayout buttonLayout = new ButtonLayout();
        buttonLayout.setLayout(null);

        JButton startButton = new JButton("Start Game");
        setStartButton(gameWindow, MEDIUM_FONT, startButton);
        buttonLayout.add(startButton);

        JButton exitButton = new JButton("Close Game");
        setExitButton(MEDIUM_FONT, exitButton);
        buttonLayout.add(exitButton);

        getContentPane().add(BorderLayout.WEST, buttonLayout);


        setVisible(true);

    }

    private void setExitButton(Font MEDIUM_FONT, JButton exitButton) {
        exitButton.setPreferredSize(new Dimension(140, 40));
        exitButton.setBackground(Color.black);
        exitButton.setBounds(30, 150, 140, 40);
        exitButton.setBorder(new LineBorder(Color.green));
        exitButton.setFont(MEDIUM_FONT);
        exitButton.setForeground(Color.green);
        exitButton.setOpaque(true);
        exitButton.addActionListener(e -> {
            System.exit(0);
        });
    }

    private void setStartButton(GameWindow gameWindow, Font MEDIUM_FONT, JButton startButton) {
        startButton.setPreferredSize(new Dimension(140, 40));
        startButton.setBounds(30, 80, 140, 40);
        startButton.setBackground(Color.black);
        startButton.setBorder(new LineBorder(Color.green));
        startButton.setFont(MEDIUM_FONT);
        startButton.setForeground(Color.green);
        startButton.setOpaque(true);
        startButton.addActionListener(e -> {
            Main.State = Main.STATE.GAME;
            setVisible(false);
            gameWindow.setVisible(true);
        });
    }

}
