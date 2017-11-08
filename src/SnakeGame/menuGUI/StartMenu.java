package SnakeGame.menuGUI;


import SnakeGame.Main;

import javax.swing.*;
import java.awt.*;

public class StartMenu extends JFrame {
    public StartMenu(Main main) {
        super("MENU");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 400);
        setLocation(200, 100);

        Font LARGE_FONT = new Font("Tahoma", Font.BOLD, 35);


        JLabel topLabel = new JLabel("The Snake Game");
        topLabel.setOpaque(true);
        topLabel.setFont(LARGE_FONT);
        topLabel.setHorizontalAlignment(JLabel.CENTER);
        topLabel.setForeground(Color.GREEN);
        topLabel.setBackground(Color.black);
        getContentPane().add(BorderLayout.NORTH, topLabel);

        ButtonLayout buttonLayout = new ButtonLayout(this, main);

        LevelsLayout levelsLayout = new LevelsLayout(main);

        getContentPane().add(BorderLayout.WEST, buttonLayout);
        getContentPane().add(BorderLayout.CENTER, levelsLayout);

        setVisible(true);
    }
}
