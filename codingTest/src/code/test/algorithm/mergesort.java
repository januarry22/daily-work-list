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
    private static int[] SORTED;
    public static void main(String[] args){

        int[] arr = {5, 2, 3, 1};


        SORTED = new int[arr.length];
        merge_split(arr, 0, arr.length-1);
        SORTED = null;
    }

    public static void merge_split(int arr[], int left, int right){
        if(left == right){
            return;
        }
        int mid = (left + right)/2;

        merge_split(arr, left, mid);		// 절반 중 왼쪽 부분리스트(left ~ mid)
        merge_split(arr, mid + 1, right);	// 절반 중 오른쪽 부분리스트(mid+1 ~ right)

        merge_sort(arr, left, mid, right);
    }


    public static void merge_sort(int arr[],int left,int mid, int right){
    //   int[] SORTED = new int[arr.length];

        int left_point = left;
        int right_point = mid+1;
        int idx=left;              // 안정정렬이기 때문에 index값 설정

        while(left_point <= mid && right_point <= right) {
            /*
             *  왼쪽 부분리스트 l번째 원소가 오른쪽 부분리스트 r번째 원소보다 작거나 같을 경우
             *  왼쪽의 l번째 원소를 새 배열에 넣고 l과 idx를 1 증가시킨다.
             */
            if(arr[left_point] <= arr[right_point]) {
                SORTED[idx] = arr[left_point];
                idx++;
                left_point++;
            }
            /*
             *  오른쪽 부분리스트 r번째 원소가 왼쪽 부분리스트 l번째 원소보다 작거나 같을 경우
             *  오른쪽의 r번째 원소를 새 배열에 넣고 r과 idx를 1 증가시킨다.
             */
            else {
                SORTED[idx] = arr[right_point];
                idx++;
                right_point++;
            }
        }

        /*
         * 왼쪽 부분리스트가 먼저 모두 새 배열에 채워졌을 경우 (l > mid)
         * = 오른쪽 부분리스트 원소가 아직 남아있을 경우
         * 오른쪽 부분리스트의 나머지 원소들을 새 배열에 채워준다.
         */
        if(left_point > mid) {
            while(right_point <= right) {
                SORTED[idx] = arr[right_point];
                idx++;
                right_point++;
            }
        }

        /*
         * 오른쪽 부분리스트가 먼저 모두 새 배열에 채워졌을 경우 (r > right)
         * = 왼쪽 부분리스트 원소가 아직 남아있을 경우
         * 왼쪽 부분리스트의 나머지 원소들을 새 배열에 채워준다.
         */
        else {
            while(left_point <= mid) {
                SORTED[idx] = arr[left_point];
                idx++;
                left_point++;
            }
        }


//        //TODO : left, right 모두 있을떄
//        while (left_point < mid && right_point < right){
//            if (arr[left_point] > arr[right_point]){
//                SORTED[idx] = arr[right_point];
//                idx++;
//                right_point++;
//            }else{
//                SORTED[idx] = arr[left_point];
//                idx++;
//                left_point++;
//            }
//        }
//
//        //TODO : left 만 있을때
//        while(left_point >= mid){
//            SORTED[idx] = arr[left_point];
//            idx++;
//            left_point++;
//        }
//
//        //TODO : right 만 있을때
//        while(right_point >= right){
//            SORTED[idx] = arr[right_point];
//            idx++;
//            right_point++;
//        }

        for(int a : SORTED){
            System.out.print(a+"\n");
        }


        for(int i = left; i <= right; i++) {
            arr[i] = SORTED[i];
        }
     //   return SORTED;
    }
}
