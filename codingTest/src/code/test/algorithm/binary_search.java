package code.test.algorithm;

import java.util.Arrays;

/*
* JAVA 이진 탐색
*
* */
public class binary_search {
    public static int[] arr = {5, 2, 3, 1, 9, 11, 15, 16, 33, 23};
    public static void main(String[] args){

        Arrays.sort(arr);
        System.out.print("a :"+  binarySearch(5, 0, arr.length-1));
    }

    static boolean binarySearch(int key, int low, int high) {

        int mid;

        if(low <= high){
            mid = (low + high ) / 2;
            if (key == arr[mid]){
                return true;
            }else if (key > arr[mid]){
                return binarySearch(key, mid+1, high);
            }else{
                return  binarySearch(key, low, mid-1);
            }
        }

        return false;
    }
}
