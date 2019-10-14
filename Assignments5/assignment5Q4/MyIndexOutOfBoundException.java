package assignment5Q4;

public class MyIndexOutOfBoundException extends RuntimeException {

    public MyIndexOutOfBoundException(int lowerBound, int upperBound, int index) {
        super("Error Message: Index: " + index + ", but Lower bound: " + lowerBound + ", Upper bound: " + upperBound);
    }
}
