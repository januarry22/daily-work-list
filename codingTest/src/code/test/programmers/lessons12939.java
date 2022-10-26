package code.test.programmers;

import java.awt.*;
import java.util.Arrays;
import java.util.stream.Stream;

/*
 * [프로그래머스] - 최댓값과 최솟값
 * */
public class lessons12939 {

    public static void main(String[] args) {

        String s = "-1 -2 -3 -4";
        System.out.println(solution(s));
    }

    public static String solution (String s) {
        String answer ="";

        int[] a = Stream.of(s.split(" ")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(a);

        answer = a[0] +" "+a[a.length-1];

        return answer;
    }
}
