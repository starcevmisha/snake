package SnakeGame.menuGUI;


import SnakeGame.Game;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;


public class LevelsLayout extends JPanel {
    private static final int SIDE = 2;

    public LevelsLayout() {
        setPreferredSize(new Dimension(600, 400));
        setBackground(Color.BLACK);

        Font MEDIUM_FONT = new Font("Tahoma", Font.BOLD, 20);

        ButtonGroup btnGroup = new ButtonGroup();

        JPanel btnPannel = new JPanel(new GridLayout(2, 2));
        btnPannel.setBorder((BorderFactory.createTitledBorder(BorderFactory
                        .createLineBorder(Color.GREEN),
                "Choose Level", TitledBorder.LEFT,
                TitledBorder.DEFAULT_POSITION,
                new Font("tahoma", Font.PLAIN, 16),
                Color.GREEN))
        );

        btnPannel.setBackground(Color.BLACK);

        ActionListener listener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (Objects.equals(e.getActionCommand(), "Level 1"))
                    Game.Level = 1;
                if (Objects.equals(e.getActionCommand(), "Level 2"))
                    Game.Level = 2;
                if (Objects.equals(e.getActionCommand(), "Level 3"))
                    Game.Level = 3;
            }
        };


        for (int i = 0; i < SIDE * SIDE; i++) {
            JToggleButton btn = new JToggleButton("Level " + (i + 1));
            ImageIcon level1Ico = new ImageIcon(String.format("src\\SnakeGame\\menuGUI\\levels_ico\\level_%s.png", i + 1));
            btn.setIcon(level1Ico);
            btn.setSize(100, 100);

            btn.setBackground(Color.black);
            btn.setForeground(Color.green);
            btn.addActionListener(listener);
            btnGroup.add(btn);
            btnPannel.add(btn);
        }
        add(btnPannel, BorderLayout.CENTER);


    }
}
