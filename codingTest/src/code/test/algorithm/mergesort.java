package code.test.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * JAVA 병합 정렬 merge sort
 * @param arr		정렬할 배열
 * @param left	배열의 시작점
 * @param mid	배열의 중간점
 * @param right	배열의 끝 점
 * */
public class mergesort {

    public static void main(String[] args) {

        int[] arr = {5, 2, 3, 1, 7, 4, 6, 9};

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(merge(arr)));
    }

    public static int[] merge(int arr[]) {
        if (arr.length<2){
            return arr;
        }
        int mid = (arr.length) / 2;

        int[] left_arr = merge(Arrays.copyOfRange(arr, 0, mid));
        int[] right_arr = merge(Arrays.copyOfRange(arr, mid, arr.length));

        int[] SORTED = new int[arr.length];
        int left_p=0, right_p=0, idx=0;

        while(left_p < left_arr.length && right_p <right_arr.length){
            if(left_arr[left_p] < right_arr[right_p]){
                SORTED[idx++] = left_arr[left_p++];
            }else{
                SORTED[idx++] = right_arr[right_p++];
            }
        }


        while(left_p < left_arr.length){
            SORTED[idx++] = left_arr[left_p++];
        }

        while (right_p < right_arr.length){
            SORTED[idx++] = right_arr[right_p++];
        }

        return SORTED;
    }

}
