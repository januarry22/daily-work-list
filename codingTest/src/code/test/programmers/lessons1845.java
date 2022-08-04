package code.test.programmers;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/*
* [프로그래머스] - 폰켓몬
 * */
public class lessons1845 {

    public static void main(String[] args){

    }


    public static int solution(int[] nums) {
        int answer = 0;

        int K = nums.length / 2; // 3
        int[] result = Arrays.stream(nums).distinct().toArray(); // 2

        if(result.length <= K){
            System.out.println(result.length);
           return result.length;
        }else{
            System.out.println(K);
           return K;
        }
    }



    @Test
    public void 정답() {
        Assert.assertEquals(2, solution(new int[]{3, 1, 2, 3}));
    }
}
