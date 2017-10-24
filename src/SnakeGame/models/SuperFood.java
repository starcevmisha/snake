package SnakeGame.models;

public class SuperFood extends Food {
    public final int probability = 120;
    public boolean visible = false;
    private int time = 0;

    public SuperFood() {
        x = 12;
        y = 6;
    }

    public void setVisible() {
        visible = true;
        time = 50;
    }

    public void check() {
        time--;
        if (time <= 0)
            visible = false;
    }
}
