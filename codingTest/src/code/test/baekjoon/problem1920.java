package code.test.baekjoon;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/*
 * 백준 - 수찾기
 *
 * - 데이터 정렬 후 이진탐색 으로 풀이
 * */
public class problem1920 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] N_arr = new int[N];

        for (int i = 0; i < N; i++) {
            N_arr[i] = sc.nextInt();
        }


        int M = sc.nextInt();
        int[] M_arr = new int[M];

        for (int i = 0; i < M; i++) {
            M_arr[i] = sc.nextInt();
        }


        Arrays.sort(N_arr);
        for (int key : M_arr) {
            if (binarySearch(N_arr, key, 0, N_arr.length - 1)) {
                System.out.print(1 + "\n");
            } else {
                System.out.print(0 + "\n");
            }
        }


    }


    static boolean binarySearch(int[] arr, int key, int low, int high) {
        int mid;
        if (low <= high) {
            mid = (low + high) / 2;
            if (key == arr[mid]) {
                return true;
            } else if (key > arr[mid]) {
                return binarySearch(arr, key, mid + 1, high);
            } else {
                return binarySearch(arr, key, low, mid - 1);
            }
        }
        return false;
    }

}
