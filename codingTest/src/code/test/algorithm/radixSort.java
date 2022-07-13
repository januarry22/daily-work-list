package code.test.algorithm;

import java.util.Arrays;

/*
 * JAVA radix sort
 * */
public class radixSort {
    public static void main(String[] args) {
        int[] arr = {5, 2, 3, 1, 2, 4, 6};

        sort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }


    /* 정렬 */
    public static void sort(int arr[], int left, int right) {
        /* 정렬할 원소가 1개 이하 이므로 리턴*/
        if (left >= right) {
            return;
        }

        int pivot = partition(arr, left, right);

        sort(arr, left, pivot - 1);
        sort(arr, pivot + 1, right);
    }

    public static int partition(int[] arr, int left, int right) {
        /* 부분요소의 왼쪽요소를 피벗으로 세팅 */
        int pivot = arr[left];
        int first = left;
        int last = right;

        /* 부분배열의 마지막 요소보다 작을때 까지만 실행 */
        while (first < last) {
            /* 마지막에 위치한 요소가 pivot보다 작거나 같을 때까지 last 인덱스감소 */
            while (pivot < arr[last]) {
                last--;
            }
            /*  first 요소가 last 요소보다 작고
            *   첫번째 위치한 요소가 pivot 보다 클 때까지 인덱스 증가
            *  */
            while (first < last && pivot >= arr[first]) {
                first++;
            }
            swap(arr, first, last);
        }
        arr[left] = arr[first];
        arr[first] = pivot;

        return first;
    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
