package Lessons.Lesson12;

import java.util.Arrays;

public class Main {
    private static final int SIZE = 10_000_000;
    private static final int HALF = SIZE / 2;

    public static void main(String[] args) {
        float[] arr = new float[SIZE];
        float[] streamsArr = new float[SIZE];

        fillingAnArrayWithStreams(streamsArr);
        fillingArray(arr);

    }


    private static void fillingAnArrayWithStreams(float[] arr){
        long time = System.currentTimeMillis();
        float[] firstHalf = new float[HALF];
        float[] lastHalf = new float[HALF];


        Thread stream1 = new Thread(() -> {
            Arrays.fill(firstHalf, 1);
            fillArrayWithFormula(firstHalf);
        });
        Thread stream2 = new Thread(() -> {
            Arrays.fill(lastHalf, 1);
            fillArrayWithFormula(lastHalf, HALF);
        });

        stream1.start();
        stream2.start();
        try {
            stream1
                    .join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            stream2
                    .join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.arraycopy(firstHalf, 0, arr, 0, HALF);
        System.arraycopy(lastHalf, 0, arr, HALF, HALF);

        System.currentTimeMillis();
        System.out.print("fillingAnArrayWithStreams() execution time: ");
        System.out.print(System.currentTimeMillis() - time);
        System.out.println(" ms");
    }

    private static void fillingArray(float[] arr){
        long time = System.currentTimeMillis();

        Arrays.fill(arr, 1);
        fillArrayWithFormula(arr);

        System.currentTimeMillis();
        System.out.print("fillingArray() execution time: ");
        System.out.print(System.currentTimeMillis() - time);
        System.out.println(" ms");
    }

    private static void fillArrayWithFormula(float[] arr){
        int firstIndex = 0;
        fillArrayWithFormulaStartSpecifiedIndex(arr, firstIndex);
    }

    private static void fillArrayWithFormula(float[] arr, int firstIndex){
        fillArrayWithFormulaStartSpecifiedIndex(arr, firstIndex);
    }

    private static void fillArrayWithFormulaStartSpecifiedIndex(float[] arr, int index) {
        for (int i = 0; i < arr.length; i++) {
            float mainArrayIndex = i + index;
            arr[i] = (float)(arr[i] * Math.sin(0.2f + mainArrayIndex / 5)
                    * Math.cos(0.2f + mainArrayIndex / 5) * Math.cos(0.4f + mainArrayIndex / 2));
        }
    }

}
