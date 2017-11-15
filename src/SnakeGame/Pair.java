package SnakeGame;

import java.io.Serializable;

public class Pair<L, R> implements Serializable {

    private final L left;
    private final R right;

    public Pair(L left, R right) {
        this.left = left;
        this.right = right;
    }

    public L getLeft() {
        return left;
    }

    public R getRight() {
        return right;
    }

    @Override
    public int hashCode() {
        return left.hashCode() ^ right.hashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Pair)) return false;
        Pair otherAsPair = (Pair) other;
        return this.left.equals(otherAsPair.getLeft()) &&
                this.right.equals(otherAsPair.getRight());
    }

}