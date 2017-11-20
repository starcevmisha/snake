package SnakeGame.SwingGUI.gameGUI;

import SnakeGame.Direction;
import SnakeGame.Game;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyController extends KeyAdapter {
    //private JFrame gameWindow;
    private Game game;

    KeyController(Game game, JFrame gameWindow) {
        this.game = game;
        //this.gameWindow = gameWindow;
    }

    @Override
    public void keyPressed(KeyEvent event) {
        switch (event.getKeyCode()) {
            case KeyEvent.VK_W:
            case KeyEvent.VK_UP:
                if (game.direction != Direction.Down)
                    game.direction = Direction.Up;
                break;

            case KeyEvent.VK_S:
            case KeyEvent.VK_DOWN:
                if (game.direction != Direction.Up)
                    game.direction = Direction.Down;
                break;

            case KeyEvent.VK_A:
            case KeyEvent.VK_LEFT:
                if (game.direction != Direction.Right)
                    game.direction = Direction.Left;
                break;

            case KeyEvent.VK_D:
            case KeyEvent.VK_RIGHT:
                if (game.direction != Direction.Left)
                    game.direction = Direction.Right;
                break;

            case KeyEvent.VK_P:
                Game.isPaused = !Game.isPaused;
                break;

            case KeyEvent.VK_SPACE:
                game.makeJump();
                break;

            case KeyEvent.VK_ENTER:
                game.reset();
                break;

        }
    }
}
