package assignment5Q4;

public class Main {

    public static void main(String[] args) {
        int[] a = { 1, 2, 3 };
        try {
            System.out.println(getValue(a, 4));
        } catch (MyIndexOutOfBoundException e) {
            throw e;
        }

    }

    public static int getValue(int[] a, int index) {
        if (index > a.length || index < 0) {
            throw new MyIndexOutOfBoundException(0, a.length, index);
        }
        return a[index];
    }

}
