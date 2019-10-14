package assignment5Q2;

public class Number {

    public static int count(int X, int Y) {
        try {
            return X / Y;
        } catch (RuntimeException e) {
            throw new IllegalArgumentException("input illegal");
        }

    }
}
