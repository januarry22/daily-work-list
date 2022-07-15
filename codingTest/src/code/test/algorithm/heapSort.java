package code.test.algorithm;

import java.util.Arrays;

/*
* JAVA 힙 정렬
*
* */
public class heapSort {
    public static int[] arr = {5, 2, 3, 1, 9, 11, 15, 16, 33, 23};
    public static void main(String[] args){

        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void heapSort(int[] arr) {
        int len = arr.length;

        for(int i =(len/2)-1; i>=0; i--){
            heapify(arr, len, i);
        }

        for(int i = len-1; i>0; i--){
            swap(arr, 0, i);
            heapify(arr, i, 0);
        }
    }

    public static void heapify(int[] arr, int len, int n){

        int parent=n;
        int left = n*2 +1;
        int right = n*2 +2;

        if(left < len && arr[parent] < arr[left]){
            parent = left;
        }
        if(right < len && arr[parent] < arr[right]){
            parent = right;
        }

        if(n != parent){
            swap(arr, parent, n);
            heapify(arr, len, parent);
        }

    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
