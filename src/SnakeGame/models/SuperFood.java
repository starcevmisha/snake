package SnakeGame.models;

public class SuperFood extends Food {
    public int probability = 130;
    public boolean isVisible = false;
    private int time = 0;

    public SuperFood() {
        x = 12;
        y = 6;
    }

    public void setVisible() {
        isVisible = true;
        time = 50;
    }

    public void check() {
        time--;
        if (time <= 0)
            isVisible = false;
    }
}
