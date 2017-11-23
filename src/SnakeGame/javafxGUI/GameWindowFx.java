package SnakeGame.javafxGUI;

import SnakeGame.Game;
import SnakeGame.IGameGui;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class GameWindowFx extends Application implements IGameGui {
    private Game game;

    public static void main(String[] args) {
//        new GameWindowFx();
        launch(args);
    }

    public void Settings(Game game) {
        this.game = game;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane root = new BorderPane();
        root.setStyle("-fx-background-color: black");
        root.setLeft(new MainPane(game));
        root.setRight(new Button("Right"));

        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void repaint() {

    }
}
