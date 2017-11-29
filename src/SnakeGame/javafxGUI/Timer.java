package SnakeGame.javafxGUI;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class Timer {
    public void tick(Window w) {
        Timeline timeline = new Timeline(new KeyFrame(
                Duration.millis(150),
                ae -> w.repaint()));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

}

