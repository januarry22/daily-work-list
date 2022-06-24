package code.test.algorithm;

import java.util.Scanner;

/*
* JAVA 재귀 함수
* */
public class dynamicprogramming {
    static int[] dp = new int[1000];
    public static void main(String[] args){

        for (int i=0; i<11; i++){
          //  System.out.print(fibo(i)+"\n");
          //  System.out.print(dp_Topdow(i)+"\n");
            System.out.print(dp_Bottomup(i)+"\n");
        }

    }

    // 재귀호출로 구현
    static int fibo(int x) {
        if (x<=1)
            return x;
        return fibo(x-1) + fibo(x-2);
    }

    // 동적계획법 - 하향식(Memoization)
    static int dp_Topdow(int x) {
        if (x<=1)
            return x;
        if(dp[x] != 0) return dp[x];
        dp[x] = fibo(x-1) + fibo(x-2);
        return dp[x];
    }

    // 동적계획법 - 상향식
    static int dp_Bottomup(int x) {
        dp[1] =1;
        dp[2] =2;
        for(int i=3; i<x+1; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[x];
    }
}
