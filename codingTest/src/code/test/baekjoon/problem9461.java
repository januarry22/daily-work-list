package code.test.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
* JAVA 재귀 함수
* */
public class problem9461 {
    public static void main(String[] args) {
        int[] dp = new int[101];

        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        for(int i=1; i< 98; i++) {
            dp[i+3] = dp[i]  + dp[i+1];
        }


        System.out.print("\n");
        System.out.print(dp[2]);
        System.out.print("\n");
        System.out.print(dp[6]);
        System.out.print("\n");
        System.out.print(dp[12]);
    }
}
