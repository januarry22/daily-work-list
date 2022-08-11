package code.test.programmers;

import java.util.Arrays;

/*
 * [프로그래머스] -제일 작은 수 제거하기
 * */
public class lessons12935 {

    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 1};
        int[] answer;

        Arrays.sort(arr);

        if (arr.length > 1) {
            answer = new int[arr.length-1];

            for (int i = arr.length-1; i >= 1; i--) {
                answer[arr.length-i-1] = arr[i];
            }

        } else {
            answer = new int[]{-1};
        }

        System.out.println(Arrays.toString(answer));
    }

}
