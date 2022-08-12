package code.test.programmers;

import java.util.Arrays;

/*
 * [프로그래머스] - 두 정수 사이의 합
 * */
public class lessons12912 {


    public static void main(String[] args) {
        long answer = 0;

        int a = 3;
        int b = 5;

        if (a <= b) {

            for (int i = a; i <= b; i++) {
                answer += i;
            }
        }else{
            for (int i = b; i <= a; i++) {
                answer += i;
            }
        }
        System.out.println(answer);

    }


}
