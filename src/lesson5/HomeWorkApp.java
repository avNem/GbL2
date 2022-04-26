package lesson5;

import java.util.Arrays;

public class HomeWorkApp {
    static final int size = 10_000_000;
    static final int half_size = size / 2;

    public static void main(String[] args) throws InterruptedException {
        firstMeth();
        secondMethod();
    }

    public static void firstMeth() {
        long startTime = System.currentTimeMillis();

        float arr[] = new float[size];

        Arrays.fill(arr, 1.0f);

        for (int i = 0; i < arr.length; i++) {
            arr[i] =  (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("One thread time: " + (System.currentTimeMillis() -
                startTime) + " ms.");
    }


    public static void secondMethod() throws InterruptedException {

        long startTime = System.currentTimeMillis();
        float[] arr = new float[size];
        Arrays.fill(arr, 1.0f);


        float[] leftHalf = new float[half_size];
        float[] rightHalf = new float[half_size];

        System.arraycopy(arr,0, leftHalf,0, half_size);
        System.arraycopy(arr, half_size, rightHalf,0, half_size);

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < leftHalf.length; i++) {
                    leftHalf[i] =  (float) (leftHalf[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < rightHalf.length; i++) {
                    rightHalf[i] =  (float) (rightHalf[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
            }
        });

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        float mergArr[] = new float[size];
        System.arraycopy(leftHalf,0, mergArr,0, half_size);
        System.arraycopy(rightHalf, 0, mergArr,half_size, half_size);

        System.out.println("Two thread time: " + (System.currentTimeMillis() -
                startTime) + " ms.");
    }
}
