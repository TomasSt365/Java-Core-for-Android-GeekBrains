package Lessons.Lesson12;

public class Main {
    private static final int SIZE = 10_000_000;
    private static final int HALF = SIZE / 2;
    private static final Object lock1 = new Object();

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
            fillTheArrayWithOnes(firstHalf, HALF);
            fillTheArrayUsingTheFormula(firstHalf, HALF);
            synchronized (lock1){
                System.arraycopy(firstHalf, 0, arr, 0, HALF);
            }
        });
        Thread stream2 = new Thread(() -> {
            fillTheArrayWithOnes(lastHalf, HALF);
            fillTheArrayUsingTheFormula(lastHalf, HALF, HALF);
            synchronized (lock1){
                System.arraycopy(lastHalf, 0, arr, HALF, HALF);
            }
        });

        stream1.start();
        stream2.start();

        System.currentTimeMillis();
        System.out.print("fillingAnArrayWithStreams() execution time: ");
        System.out.print(System.currentTimeMillis() - time);
        System.out.println(" ms");
    }

    private static void fillingArray(float[] arr){
        long time = System.currentTimeMillis();

        fillTheArrayWithOnes(arr,SIZE);
        fillTheArrayUsingTheFormula(arr,SIZE);

        System.currentTimeMillis();
        System.out.print("fillingArray() execution time: ");
        System.out.print(System.currentTimeMillis() - time);
        System.out.println(" ms");
    }

    private static void  fillTheArrayWithOnes(float[] arr, int size){
        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }
    }

    private static void fillTheArrayUsingTheFormula(float[] arr, int size){
        int firstIndexInMainArr = 0;

        for (int i = 0; i < size; i++) {
            float mainArrayIndex = i + firstIndexInMainArr;
            arr[i] = (float)(arr[i] * Math.sin(0.2f + mainArrayIndex / 5)
                    * Math.cos(0.2f + mainArrayIndex / 5) * Math.cos(0.4f + mainArrayIndex / 2));
        }
    }

    private static void fillTheArrayUsingTheFormula(float[] arr, int size, int firstIndexInMainArr){
        for (int i = 0; i < size; i++) {
            float mainArrayIndex = i + firstIndexInMainArr;
            arr[i] = (float)(arr[i] * Math.sin(0.2f + mainArrayIndex / 5)
                    * Math.cos(0.2f + mainArrayIndex / 5) * Math.cos(0.4f + mainArrayIndex / 2));
        }
    }

}
