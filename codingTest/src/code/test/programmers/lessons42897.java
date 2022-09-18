package code.test.programmers;

import javax.swing.border.MatteBorder;

/*
 * [프로그래머스] - 도둑질
 * */
public class lessons42897 {

    public static void main(String[] args) {
        int[] money = {1, 2, 3, 1};

        System.out.println(solution(money));
    }

    public static int solution(int[] money) {

        int N = money.length;

        int[] dp1 = new int[N];
        int[] dp2 = new int[N];

        dp1[0] = money[0];
        dp1[1] = money[0];

        dp2[0] = 0;
        dp2[1] = money[1];

        for (int i = 2; i < N; i++) {
            dp1[i] = Math.max(dp1[i - 2] + money[i], dp1[i - 1]);
            dp2[i] = Math.max(dp2[i - 2] + money[i], dp2[i - 1]);
        }


        return Math.max(dp1[N - 2], dp2[N - 1]);
    }

}
