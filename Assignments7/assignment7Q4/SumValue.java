package assignment7Q4;

import java.util.Random;

public class SumValue {

    public static void main(String[] args) {
        int[] arr = new int[200000000];
        generateRandomArray(arr);
        long time1 = System.currentTimeMillis();
        long sum = 0;
        try {
            sum = sum(arr);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        long time2 = System.currentTimeMillis();
        System.out.println("MultiThread Sum: " + sum);
        System.out.println("Using Time: " + (time2 - time1));
        long time3 = System.currentTimeMillis();
        System.out.println("Internal Sum: " + normalSum(arr));
        long time4 = System.currentTimeMillis();
        System.out.println("Using Time: " + (time4 - time3));
    }

    /* generate array of random numbers */
    static void generateRandomArray(int[] arr) {
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(10);
        }
    }

    /* get sum of an array using 4 threads */
    static long sum(int[] arr) throws Exception {
        long sumres = 0;
        MultiThreadSum sum1 = new MultiThreadSum(arr, 0, arr.length / 4);
        MultiThreadSum sum2 = new MultiThreadSum(arr, arr.length / 4, arr.length / 4 * 2);
        MultiThreadSum sum3 = new MultiThreadSum(arr, arr.length / 4 * 2, arr.length / 4 * 3);
        MultiThreadSum sum4 = new MultiThreadSum(arr, arr.length / 4 * 3, arr.length);
        sum1.start();
        sum2.start();
        sum3.start();
        sum4.start();
        sum1.join();
        sum2.join();
        sum3.join();
        sum4.join();
        sumres = sum1.getSumarr() + sum2.getSumarr() + sum3.getSumarr() + sum4.getSumarr();
        return sumres;
    }

    static long normalSum(int[] arr) {
        long sumarr = 0;
        for (int i = 0; i < arr.length; i++) {
            sumarr += arr[i];
        }
        return sumarr;
    }

}

class MultiThreadSum extends Thread {
    private int[] arr;
    private int start;
    private int end;
    private long sumarr;

    public MultiThreadSum(int[] arr, int start, int end) {
        this.arr = arr;
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        try {
            for (int i = start; i < end; i++) {
                sumarr += arr[i];
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public long getSumarr() {
        return sumarr;
    }
}
