package code.test.programmers;

import java.util.Arrays;

/*
 * [프로그래머스] - N으로 표현
 * */
public class lessons42895 {

    public static int answer =0;
    public static void main(String[] args) {
        int N = 5;
        int number = 12;
        int answer = 0;

    }

    public static void dfs(int n, int number, int cnt, int prev) {

        /* 8회가 넘어가면 return */
        if(cnt > 8){
            answer = -1;
            return;
        }
        if(prev==number){
            answer =  Math.min(answer, cnt);
            return;
        }
        int tempN = n;


        for (int i = 0; i < 8 - cnt; i++) {
            int newCount = cnt + i + 1;
            dfs(n, number, newCount, prev + tempN);
            dfs(n, number, newCount, prev - tempN);
            dfs(n, number, newCount, prev / tempN);
            dfs(n, number, newCount, prev * tempN);

            tempN = tempN * 10 + n;
        }
    }

}
