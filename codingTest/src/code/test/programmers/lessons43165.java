package code.test.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
 * [프로그래머스] - 타겟 넘버
 * */
public class lessons43165 {
    public static int[] numbers = {1, 1, 1, 1, 1};
    public static int target= 3;

    public static void main(String[] args) {
        dfs(numbers, target , 0 , 0)


    }

    public static int dfs(int[] numbers, int target, int index, int num) {
        if (index == numbers.length) {
            return num==target ? 1 : 0;

        }else{
            return dfs(numbers, target, index+1, num+numbers[index]) +
                    dfs(numbers, target, index+1, num-numbers[index]);
        }
    }


}
