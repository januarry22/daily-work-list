package code.test.algorithm;

import java.util.Arrays;

/*
* JAVA 순차 탐색
*
* */
public class sequen_search {
    public static int[] arr = {5, 2, 3, 1, 9, 11, 15, 16, 33, 23};
    public static void main(String[] args){

        System.out.print("index :"+  sequenSearch(15));
        System.out.print("not in index :"+  sequenSearch(18));
    }

    static int sequenSearch(int key) {

//        for(int i = 0; i<arr.length; i++){
//            if (key == arr[i]){
//                return i;
//            }
//        }
        for(int a : arr){
            if (key == a){
                return a;
            }
        }
        return -1;
    }
}
