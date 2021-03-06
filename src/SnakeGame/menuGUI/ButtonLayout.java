package SnakeGame.menuGUI;


import SnakeGame.Main;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class ButtonLayout extends JPanel {
    public static Thread myThread = null;
    ButtonLayout(JFrame parentFrame, Main main) {
        Font MEDIUM_FONT = new Font("Tahoma", Font.BOLD, 16);
        setPreferredSize(new Dimension(200, 800));
        setBackground(Color.BLACK);
        setLayout(null);

        JButton startButton = new JButton("Start Game");
        startButton.setPreferredSize(new Dimension(140, 40));
        startButton.setBounds(30, 80, 140, 40);
        startButton.setBackground(Color.black);
        startButton.setBorder(new LineBorder(Color.green));
        startButton.setFont(MEDIUM_FONT);
        startButton.setForeground(Color.green);
        startButton.setOpaque(true);
        startButton.addActionListener(e -> {
            if (Main.gameThread != null)
                Main.gameThread.interrupt();
            Main.gameThread = new Thread(main);
            Main.gameThread.start();
        });
        add(startButton);

        JButton exitButton = new JButton("Close Game");
        exitButton.setPreferredSize(new Dimension(140, 40));
        exitButton.setBackground(Color.black);
        exitButton.setBounds(30, 150, 140, 40);
        exitButton.setBorder(new LineBorder(Color.green));
        exitButton.setFont(MEDIUM_FONT);
        exitButton.setForeground(Color.green);
        exitButton.setOpaque(true);
        exitButton.addActionListener(e -> System.exit(0));
        add(exitButton);
    }
}
