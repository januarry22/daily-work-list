package code.test.algorithm;

import java.util.Arrays;

/*
 * JAVA 퀵 정렬 quickSort
 * */
public class quickSort {
    public static void main(String[] args) {
        int[] arr = {5, 2, 3, 1, 2, 4, 6};

        sort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }


    public static void sort(int arr[], int left, int right) {
        if (left >= right) {
            return;
        }

        int pivot = partition(arr, left, right);

        sort(arr, left, pivot - 1);
        sort(arr, pivot + 1, right);
    }

    public static int partition(int[] arr, int left, int right) {
        int pivot = arr[left];
        int i = left, j = right;

        while (i < j) {
            while (pivot < arr[j]) {
                j--;
            }
            while (i < j && pivot >= arr[i]) {
                i++;
            }
            swap(arr, i, j);
        }
        arr[left] = arr[i];
        arr[i] = pivot;

        return i;
    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
