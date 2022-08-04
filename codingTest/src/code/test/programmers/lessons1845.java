package code.test.programmers;

import java.util.Arrays;

/*
* [프로그래머스] - 폰켓몬
 * */
public class lessons1845 {

    public static void main(String[] args){
        int nums[] = {3, 3, 3, 2, 2, 2};
        int answer = 0;

        int K = nums.length / 2; // 3
        int[] result = Arrays.stream(nums).distinct().toArray(); // 2

        if(result.length <= K){
            System.out.println(result.length);
        }else{
            System.out.println(K);
        }

    }
}
