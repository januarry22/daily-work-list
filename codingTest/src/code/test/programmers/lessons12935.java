package code.test.programmers;

import java.util.Arrays;

/*
 * [프로그래머스] -제일 작은 수 제거하기
 * */
public class lessons12935 {

    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 1};
        int[] answer;


        if (arr.length == 1) {
            answer = new int[]{-1};
        }
        int min = Integer.MAX_VALUE;
        for(int a : arr) {
            if(min > a) min = a;
        }

        int[] newArr = new int[arr.length-1];
        int index = 0;
        for(int a : arr) {
            if(min != a) newArr[index++] = a;
        }

        System.out.println(Arrays.toString(newArr));
    }

}
