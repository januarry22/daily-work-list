package code.test.algorithm;

import java.util.Arrays;
import java.util.Random;

/*
 * JAVA radix sort
 * */
public class radixSort {
    static final int N = 10;
    public static void main(String[] args) {
        Random random = new Random();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = random.nextInt(100);
        }
        System.out.println(Arrays.toString(arr));
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }


    public static void radixSort(int[] arr) {
        // 최대값 구하기
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i])
                max = arr[i];
        }

        countingSort(arr,max);
    }

    public static void countingSort(int[] arr,int max) {
        int[] temp = new int[N];
        int[] counting = new int[max+1];

        for (int i = 0; i < N; i++) {
            counting[arr[i]]++;
        }

        for (int i = 1; i < counting.length; i++) {
            counting[i] += counting[i - 1];
        }

        for (int i = 0; i < N; i++) {
            int index = arr[i];

            counting[index]--;
            temp[counting[index]] = index;
        }

        // 복사
        for (int i = 0; i < N; i++) {
            arr[i] = temp[i];
        }
    }

}
