package SnakeGame.menuGUI;


import SnakeGame.Game;
import SnakeGame.Main;
import SnakeGame.menuGUI.LevelCreator.LevelCreatorWindow;
import SnakeGame.models.Level;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Objects;



class LevelsLayout extends JPanel {
    //private static final int SIDE = 2;
    private static int currentLevel = 0;

    LevelsLayout(Main main) {
        setPreferredSize(new Dimension(900, 400));
        setBackground(Color.BLACK);

        //Font MEDIUM_FONT = new Font("Tahoma", Font.BOLD, 20);

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

        List<Level> levels = main.seriailizer.extractLevels();

        ActionListener listener = e -> {
            if (Objects.equals(e.getActionCommand(), "Create level"))
                new LevelCreatorWindow(main);
            else if (Objects.equals(e.getActionCommand(), "Delete level")) {
//                deleteLevel(currentLevel);
//                currentLevel = 0;
//                Game.levelNum = 0;
            } else {
                for (int i = 0; i < levels.size(); i++) {
                    if (Objects.equals(e.getActionCommand(),
                            levels.get(i).name)) {
                        Game.levelNum = i + 1;
                        currentLevel = i;

                    }
                }
            }
        };


        for (int i = 0; i < levels.size(); i++) {
            JToggleButton btn = new JToggleButton(levels.get(i).name);
            ImageIcon level1Ico = new ImageIcon(String.format(
                    "src\\SnakeGame\\menuGUI\\levels_ico\\level_%s.png",
                    i + 1));
            btn.setIcon(level1Ico);
            btn.setSize(100, 100);

            btn.setBackground(Color.black);
            btn.setForeground(Color.green);
            btn.addActionListener(listener);
            btnGroup.add(btn);
            btnPannel.add(btn);
        }

        JToggleButton btn = new JToggleButton("Create level");
        ImageIcon level1Ico = new ImageIcon("src\\SnakeGame\\" +
                "menuGUI\\levels_ico\\create_level.png");
        btn.setIcon(level1Ico);
        btn.setSize(100, 100);

        btn.setBackground(Color.black);
        btn.setForeground(Color.green);
        btn.addActionListener(listener);
        btnGroup.add(btn);
        btnPannel.add(btn);

        JToggleButton deleteBtn = new JToggleButton("Delete level");
        deleteBtn.setSize(100, 100);
        deleteBtn.setBackground(Color.black);
        deleteBtn.setForeground(Color.green);
        deleteBtn.addActionListener(listener);
        btnGroup.add(deleteBtn);
        btnPannel.add(deleteBtn);

        add(btnPannel, BorderLayout.CENTER);
    }
}
