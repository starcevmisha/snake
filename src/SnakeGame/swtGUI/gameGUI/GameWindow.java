package SnakeGame.swtGUI.gameGUI;//package SnakeGame.swtGUI.gameGUI;


import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.stage.Stage;


public class GameWindow extends Application {
    private double sceneWidth = 400;
    private double sceneHeight = 400;

    private int n = 20;
    double gridWidth = sceneWidth / n;
    private int m = 20;
    double gridHeight = sceneHeight / m;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {


        Group root = new Group();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Rectangle rectangle = new Rectangle(i * gridWidth, j * gridHeight, gridWidth, gridHeight);
                rectangle.setStroke(Color.DARKGRAY);
                rectangle.setFill(Color.BLACK);
                rectangle.setStrokeType(StrokeType.CENTERED);
                root.getChildren().add(rectangle);

            }
        }


        Scene scene = new Scene(root, sceneWidth, sceneHeight);

        primaryStage.setScene(scene);
        primaryStage.show();

    }


}