package SnakeGame;

import SnakeGame.models.*;

import java.awt.*;
import java.util.Random;

public class Game {
    public static boolean blockAction = false;
    public SuperFood superFood;
    public static boolean isGameOver = false;
    public static boolean isPaused = false;
    private final Main main;
    public boolean isMovingFromPortal = true;
    public int score = 0;
    public Snake snake;
    public Food food;
    public Portal portal;

    private Random random = new Random();
    public Wall wall;
    public Direction direction = Direction.Right;
    public static int levelNum = 1;

    private static boolean isJump = true;
    private static int jumpTime = 2;

    public Game(Main main) {
        this.main = main;
        portal = new Portal();
        snake = new Snake((int) portal.point.getX(), (int) portal.point.getY(), Main.snakeLength);
        food = new Food();
        superFood = new SuperFood();
        wall = new Wall(levelNum, main.seriailizer);
    }

    public void oneStep() {
//        if (portal.IntersectedWith(snake.getBody().get(0)))
        if (isMovingFromPortal) {
            if (!snake.AppearFromPortal(portal.point))
                isMovingFromPortal = false;
            else {
                snake.growUp();
            }
        } else if (portal.IntersectedWith(snake.getBody().get(0))) {
            snake.RemoveHead();
            if (snake.getBody().size() == 0) {
                // TODO: make animation
                wall = new Wall((levelNum++) % 3 + 1, main.seriailizer);
                newFood();
                newSuperFood();
                isMovingFromPortal = true;
                blockAction = false;
                reset();
                return;
            } else {
                blockAction = true;
                // TODO: block actions
            }
        }


        Point head = snake.move(direction);
        Game.isGameOver =
                (snake.isLoop() || wall.isIntersectWith(head)) && !isJump;



        if (isJump && jumpTime-- < 0)
            isJump = false;
        Point oldPointFood = new Point((int) food.getX(), (int) food.getY());
        if (food.isEaten(head)) {
            score += food.type;
            if (food.type == 4)
                score += 10;
            snake.extend(oldPointFood);
            newFood();
        }
        if (superFood.isEaten(head) && superFood.isVisible) {
            snake.cut();
            score -= 20;
            newSuperFood();
            superFood.isVisible = false;
        }
        if (!superFood.isVisible)
            if (random.nextInt() % superFood.probability == 0) {
                superFood.setVisible();
                newSuperFood();
            }
        if (superFood.isVisible)
            superFood.check();

    }

    public void makeJump() {
        isJump = true;
        jumpTime = 2;
    }

    public void reset() {
        snake = new Snake((int) portal.point.getX(), (int) portal.point.getY(), snake.initialSize);
        score = 0;
        newFood();
        newSuperFood();
        isGameOver = false;
        isPaused = false;
        direction = Direction.Right;
    }

    private void newFood() {
        while (snake.isIntersectWith(food)
                || wall.isIntersectWith(food))
            food.nextFood();
    }

    private void newSuperFood() {
        while (snake.isIntersectWith(superFood)
                || wall.isIntersectWith(superFood))
            superFood.nextFood();
    }
}
