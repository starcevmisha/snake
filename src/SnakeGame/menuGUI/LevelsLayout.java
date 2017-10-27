package SnakeGame.menuGUI;


import SnakeGame.Game;
import SnakeGame.Main;
import SnakeGame.menuGUI.LevelCreator.LevelCreatorWindow;
import SnakeGame.serial.JsonLevels;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Objects;

import static SnakeGame.serial.JsonLevels.extractLevels;


class LevelsLayout extends JPanel {
    private static final int SIDE = 2;

    LevelsLayout(Main main) {
        setPreferredSize(new Dimension(900, 400));
        setBackground(Color.BLACK);

        Font MEDIUM_FONT = new Font("Tahoma", Font.BOLD, 20);

        ButtonGroup btnGroup = new ButtonGroup();

        JPanel btnPannel = new JPanel(new GridLayout(0, 3));
        btnPannel.setBorder((BorderFactory.createTitledBorder(BorderFactory
                        .createLineBorder(Color.GREEN),
                "Choose level", TitledBorder.LEFT,
                TitledBorder.DEFAULT_POSITION,
                new Font("tahoma", Font.PLAIN, 16),
                Color.GREEN))
        );

        btnPannel.setBackground(Color.BLACK);


        List<JsonLevels.Level> levels = extractLevels();

        ActionListener listener = e -> {
            if (Objects.equals(e.getActionCommand(), "Create level"))
                new LevelCreatorWindow(main);
            else {
                for (int i = 0; i < levels.size(); i++) {
                    if (Objects.equals(e.getActionCommand(), levels.get(i).name))
                        Game.levelNum = i + 1;
                }
            }
        };


        for (int i = 0; i < levels.size(); i++) {
            JToggleButton btn = new JToggleButton(levels.get(i).name);
            ImageIcon level1Ico = new ImageIcon(String.format("src\\SnakeGame\\menuGUI\\levels_ico\\level_%s.png", i + 1));
            btn.setIcon(level1Ico);
            btn.setSize(100, 100);

            btn.setBackground(Color.black);
            btn.setForeground(Color.green);
            btn.addActionListener(listener);
            btnGroup.add(btn);
            btnPannel.add(btn);
        }

        JToggleButton btn = new JToggleButton("Create level");
        ImageIcon level1Ico = new ImageIcon("src\\SnakeGame\\menuGUI\\levels_ico\\create_level.png");
        btn.setIcon(level1Ico);
        btn.setSize(100, 100);

        btn.setBackground(Color.black);
        btn.setForeground(Color.green);
        btn.addActionListener(listener);
        btnGroup.add(btn);
        btnPannel.add(btn);

        add(btnPannel, BorderLayout.CENTER);
    }
}
