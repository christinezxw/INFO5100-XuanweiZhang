package assignment7Q4;

import java.util.Random;

public class SumValue2 {

    public static void main(String[] args) {
        int[] arr = new int[100000000];
        generateRandomArray(arr);
        long sumpar = 0;
        long time1 = System.currentTimeMillis();
        try {
            sumpar = sumPar(arr);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        long time2 = System.currentTimeMillis();
        long sumseq = sumSeq(arr);
        long time3 = System.currentTimeMillis();
        System.out.println("Using thread sum: " + sumseq);
        System.out.println("Using Time: " + (time2 - time1));

        System.out.println("Using thread sum: " + sumpar);
        System.out.println("Using Time: " + (time3 - time2));

    }

    private static long sumSeq(int[] arr) {
        return sum(arr, 0, arr.length);
    }

    private static long sumPar(int[] arr) throws Exception {
        long sumres = 0;
        SumThread sum1 = new SumThread(arr, 0, arr.length / 4);
        SumThread sum2 = new SumThread(arr, arr.length / 4, arr.length / 4 * 2);
        SumThread sum3 = new SumThread(arr, arr.length / 4 * 2, arr.length / 4 * 3);
        SumThread sum4 = new SumThread(arr, arr.length / 4 * 3, arr.length);
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

    /* generate array of random numbers */
    static void generateRandomArray(int[] arr) {
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(10);
        }
    }

    /* get sum of an array using 4 threads */
    static long sum(int[] arr, int start, int end) {
        long sumarr = 0;
        for (int i = start; i < end; i++) {
            sumarr += arr[i];
        }
        return sumarr;
    }

    static class SumThread extends Thread {
        private int[] arr;
        private int start;
        private int end;
        private long sumarr;

        public SumThread(int[] arr, int start, int end) {
            this.arr = arr;
            this.start = start;
            this.end = end;
        }

        @Override
        public void run() {
            this.sumarr = sum(arr, start, end);
        }

        public long getSumarr() {
            return sumarr;
        }
    }
}
