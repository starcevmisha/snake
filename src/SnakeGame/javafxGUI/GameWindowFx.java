package SnakeGame.javafxGUI;

import SnakeGame.Direction;
import SnakeGame.Game;
import SnakeGame.IGameGui;
import SnakeGame.Main;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class GameWindowFx extends Application implements IGameGui {
    private Game game;
    private Stage mainStage;
    private MainPane mainPane;
    private InfoPane infoPane;

    public static void main(String[] args) {
        launch(args);

    }

    @Override
    public void start(Stage stage) throws Exception {
        game = new Game(new Main());
        System.out.println(12);
        mainStage = stage;
        BorderPane root = new BorderPane();
        root.setStyle("-fx-background-color: black");

        mainPane = new MainPane(game);
        mainPane.setFocusTraversable(true);
        root.setLeft(mainPane);

        infoPane = new InfoPane(game);
        root.setRight(infoPane);
        Scene scene = new Scene(root, 600, 400);
        scene.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case UP:
                case W:
                    if (game.direction != Direction.Down)
                        game.direction = Direction.Up;
                    break;
                case DOWN:
                case S:
                    if (game.direction != Direction.Up)
                        game.direction = Direction.Down;
                    break;
                case LEFT:
                case A:
                    if (game.direction != Direction.Right)
                        game.direction = Direction.Left;
                    break;
                case RIGHT:
                case D:
                    if (game.direction != Direction.Left)
                        game.direction = Direction.Right;
                    break;
                case P:
                    Game.isPaused = !Game.isPaused;
                    break;
                case SPACE:
                    game.makeJump();
                    break;

                case ENTER:
                    game.reset();
                    break;
            }
        });
        stage.setScene(scene);

        stage.show();

        Timeline timeline = new Timeline(new KeyFrame(
                Duration.millis(150),
                ae -> repaint()));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }


    @Override
    public void repaint() {
        if (!Game.isPaused && !Game.isGameOver)
            game.oneStep();
        mainPane.repaint();
        infoPane.repaint();
    }

}
